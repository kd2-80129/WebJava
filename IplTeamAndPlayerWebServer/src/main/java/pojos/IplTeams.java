package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "teams")
public class IplTeams extends BaseEntity {

	@Column(name = "name", length = 80, unique = true)
	private String teamName;

	@Column(name = "abbreviation", length = 15, unique = true)
	private String nameAbbr;

	@Column(length = 20)
	private String owner;

	@Column(name = "max_age")
	private int maxAge;

	@Column(name = "batting_avg")
	private double battingAvg;

	@Column(name = "wickets_taken")
	private int wicketsTaken;

	// Team 1 --> *Player
	// Team: one, non-owning, inverse, parent
	@OneToMany(mappedBy = "team", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
	private List<Player> players = new ArrayList<>();

	public IplTeams() {
	}

	public IplTeams(String teamName, String nameAbbr, String owner, int maxAge, double battingAvg, int wicketsTaken) {
		super();
		this.teamName = teamName;
		this.nameAbbr = nameAbbr;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public IplTeams(Integer teamId, String nameAbbr) {
		super();
		setId(teamId);
		this.nameAbbr = nameAbbr;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getNameAbbr() {
		return nameAbbr;
	}

	public void setNameAbbr(String nameAbbr) {
		this.nameAbbr = nameAbbr;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(Integer wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}	
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	//Helper methods
	public void addNewplayer(Player player) {
		this.players.add(player);
		player.setTeam(this);
	}

	@Override
	public String toString() {
		return "IplTeams [teamId=" + getId() + ", teamName=" + teamName + ", nameAbbr=" + nameAbbr + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}

}
