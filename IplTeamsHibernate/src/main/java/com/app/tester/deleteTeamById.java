package com.app.tester;
import java.util.Scanner;
import static com.app.utils.HibernateUtils.getFactory;
import org.hibernate.*;

import com.app.daos.IplTeamsDao;
import com.app.daos.IplTeamsDaoImpl;

public class deleteTeamById {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
			Scanner sc = new Scanner(System.in)){
			IplTeamsDao dao = new IplTeamsDaoImpl();
			System.out.println("Enter Team Id of the team to be deleted");
			System.out.println(dao.deleteTeamById(sc.nextInt()));
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
