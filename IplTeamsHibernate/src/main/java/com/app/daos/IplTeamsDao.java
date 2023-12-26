package com.app.daos;
import java.util.List;
import com.app.pojos.IplTeams;

public interface IplTeamsDao {
	//add a method to add new Team
	String addNewTeam(IplTeams newTeam);
	
	//Method to get Persistent POJO ref by id
	IplTeams getTeamById(Integer teamId);
	
	//Method to get all the Teams TeamId and Abbreviation 
	List<IplTeams> getAllTeamIdAndAbbreviation();
	
	//Method to get TeamsDetails By Max_AGE and WICKETS_TAKEN
	List<IplTeams> getTeamsByMaxAgeAndWicketsTaken(int maxAge, int wicketsTaken);
	
	//Method to Update Max Age and Batting Average of a specific team by teamName
	String getTeamDetailsByName(String name, int age, int wickTak);
	
	//Method to delete Team Details
	String deleteTeamById(Integer teamId);
}
