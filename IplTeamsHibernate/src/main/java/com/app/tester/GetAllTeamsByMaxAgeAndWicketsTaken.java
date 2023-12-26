package com.app.tester;
import org.hibernate.*;

import com.app.daos.IplTeamsDao;
import com.app.daos.IplTeamsDaoImpl;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class GetAllTeamsByMaxAgeAndWicketsTaken {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			IplTeamsDao dao = new IplTeamsDaoImpl();
			System.out.println("Enter Max Age and Wickets Taken : ");
			dao.getTeamsByMaxAgeAndWicketsTaken(sc.nextInt(), sc.nextInt())
			   .forEach(System.out::println);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
