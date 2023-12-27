package doas;

import pojos.IplTeams;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IplTeamsDaoImpl implements IplTeamsDao{

	@Override
	public String addNewTeam(IplTeams newTeam) {
		String mesg = "Adding team failed";
		//1. Get a Session from SF
		Session session = getFactory().getCurrentSession();
		
		//2. Begin a tx
		Transaction tx = session.beginTransaction();
		
		//3. try - save team details, commit
		//catch: runtime exception : rollback tx, throw e						
		try {
			Serializable teamId = session.save(newTeam);
			tx.commit();
			mesg = "Team Added Succesfully, Team Id = " + teamId;
		} 
		catch(RuntimeException e) {
			if(tx != null) 
				tx.rollback();
			throw e;
		}
		//newTeam --> Detached state
		return mesg;
	}

	@Override
	public List<IplTeams> getAllTeamIdAndAbbreviation() {
		List<IplTeams> list = null; //Does Not exist yet
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			String jpql = "select new com.app.pojos.IplTeams(teamId, nameAbbr) from IplTeams t";
			list = session.createQuery(jpql,IplTeams.class).getResultList();
			tx.commit();
		}
		catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public IplTeams getTeamById(Integer teamId) {
		IplTeams team = null;
		
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			team = session.get(IplTeams.class, teamId); 
			tx.commit();
		} catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return team;
	}

	@Override
	public List<IplTeams> getTeamsByMaxAgeAndWicketsTaken(int maxAge, int wicketsTaken) {
		List<IplTeams> list = null;
		
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			String jpql = "select t from IplTeams t where maxAge < :maxAge and wicketsTaken > :wicketsTaken";
			list = session.createQuery(jpql, IplTeams.class)
					.setParameter("maxAge", maxAge)
					.setParameter("wicketsTaken", wicketsTaken)
					.getResultList();
			tx.commit();
		} catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public String getTeamDetailsByName(String name, int age, int wickTak) {
		String msg = "Updation Failed!!";
		
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			String jpql="select t from IplTeams t where teamName = :name";
			IplTeams team = session.createQuery(jpql, IplTeams.class)
				   .setParameter("name", name)
				   .getSingleResult();
			team.setMaxAge(age);
			team.setWicketsTaken(wickTak);
			msg="Updation Successfull for team = " + team.getTeamName();

			tx.commit();
		} catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteTeamById(Integer teamId) {
		String mesg = "Deletion Failed!!";
		
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			IplTeams team = session.get(IplTeams.class, teamId);
			if(team != null) {
				session.delete(team);
				mesg="Deletion Successfull !! Team deleted = " + team.getTeamName();
			}
			
			tx.commit();
		} catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return mesg;
	}

	@Override
	public List<IplTeams> displayAll() {
		List<IplTeams> teams = new ArrayList<IplTeams>();
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			String jpql = "select new pojos.IplTeams(id, nameAbbr) from IplTeams t";
			teams = session.createQuery(jpql, IplTeams.class)
							.getResultList();
			tx.commit();
		} catch(RuntimeException e) {
			if(tx != null) 
				tx.rollback();
			throw e;
		}
		return teams;
	}
	
	

}
