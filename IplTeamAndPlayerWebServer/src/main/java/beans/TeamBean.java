package beans;

import java.util.List;
import doas.IplTeamsDao;
import doas.IplTeamsDaoImpl;
import pojos.IplTeams;

public class TeamBean {
	private IplTeamsDao dao;

	public TeamBean() {
		dao = new IplTeamsDaoImpl();
		System.out.println("team bean n dao created ....");
	}

	public List<IplTeams> getAllTeams() {
		List<IplTeams> list = dao.displayAll();
		System.out.println(list);
		return list;
 	}
	
}
