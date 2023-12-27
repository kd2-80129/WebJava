package doas;

import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

import pojos.IplTeams;
import pojos.Player;

public class PlayerdaoImpl implements PlayerDao{

	@Override
	public void addNewPlayer(Player newPlayer, Integer teamId) {
		String mesg = "Adding New Player Failed!!";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			IplTeams team = session.get(IplTeams.class, teamId);
			
			if(team != null) {
				team.addNewplayer(newPlayer);
				mesg="Adding New Player Successfull !!";
			}
			
			tx.commit();
		} catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
		}
		
		System.out.println(mesg);
	}

}
