package com.app.tester;

import org.hibernate.*;

import com.app.daos.IplTeamsDao;
import com.app.daos.IplTeamsDaoImpl;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class UpdateTeamMaxAgeAndWicketsTakenById {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
			Scanner sc = new Scanner(System.in)){
			IplTeamsDao dao = new IplTeamsDaoImpl();
			System.out.println("Enter Team Name and The updated to be updated Max Age and Wickets Taken: ");
			System.out.println(dao.getTeamDetailsByName(sc.next(), sc.nextInt(), sc.nextInt()));
		} catch(Exception e) {
					e.printStackTrace();
				}

	}

}
