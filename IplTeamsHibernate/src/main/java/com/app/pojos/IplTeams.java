package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="teams")
public class IplTeams {
	//Reco: Make ID property explicitly Serializable (All Wrapper Classes are Serializable)
	@Id //Primary Key
	@Column(name="team_id")
	//to specify automatic id generation using auto_increment strategy
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Integer teamId;
	
	@Column(name="name", length=80, unique = true)
	private String teamName;
	
	@Column(name="abbreviation", length=15, unique = true)
	private String nameAbbr;	
	
	@Column(length=20)
	private String owner;
	
	@Column(name="max_age")
	private int maxAge;
	
	@Column(name="batting_avg")
	private double battingAvg;
	
	@Column(name="wickets_taken")
	private int wicketsTaken;
	
	public IplTeams() {
	}
	

	public IplTeams(String teamName, String nameAbbr, String owner, int maxAge, double battingAvg,
			int wicketsTaken) {
		this.teamName = teamName;
		this.nameAbbr = nameAbbr;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public IplTeams(Integer teamId, String nameAbbr) {
		this.teamId = teamId;
		this.nameAbbr = nameAbbr;
	}


	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
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

	@Override
	public String toString() {
		return "IplTeams [teamId=" + teamId + ", teamName=" + teamName + ", nameAbbr=" + nameAbbr + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
}
