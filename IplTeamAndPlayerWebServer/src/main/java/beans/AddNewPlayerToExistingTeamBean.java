package beans;

import java.time.LocalDate;

import doas.PlayerDao;
import doas.PlayerdaoImpl;
import pojos.Player;

public class AddNewPlayerToExistingTeamBean {
	private String fn;
	private String ln;
	private String dob;
	private String avg;
	private String wickets;
	private String teamId;
	
	public AddNewPlayerToExistingTeamBean() {
		// TODO Auto-generated constructor stub
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getWickets() {
		return wickets;
	}

	public void setWickets(String wickets) {
		this.wickets = wickets;
	}
	
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public void addNewPlayer() {
		Player player = new Player(fn,ln,LocalDate.parse(dob),Double.parseDouble(avg),Integer.parseInt(wickets));
		PlayerDao dao = new PlayerdaoImpl();
		dao.addNewPlayer(player,Integer.parseInt(teamId));
	}
	
}
