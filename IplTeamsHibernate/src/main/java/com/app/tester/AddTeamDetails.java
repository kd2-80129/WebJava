package com.app.tester;
import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.*;

import com.app.daos.IplTeamsDao;
import com.app.daos.IplTeamsDaoImpl;
import com.app.pojos.IplTeams;

public class AddTeamDetails {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)){
			
			IplTeamsDao teamDao = new IplTeamsDaoImpl();
			System.out.println("Enter Team Details: Team Name, Name Abbreviation, Owner Name, Max Age, Batting Avg,"
					+ "wicketsTaken");
			IplTeams newTeam = new IplTeams(sc.next(), sc.next(), sc.next(),
					sc.nextInt(), sc.nextDouble(), sc.nextInt());
			System.out.println(teamDao.addNewTeam(newTeam));
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
