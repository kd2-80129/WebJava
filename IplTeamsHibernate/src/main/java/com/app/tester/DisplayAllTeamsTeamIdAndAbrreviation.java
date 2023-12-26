package com.app.tester;

import org.hibernate.*;
import com.app.daos.IplTeamsDao;
import com.app.daos.IplTeamsDaoImpl;
import static com.app.utils.HibernateUtils.getFactory;

public class DisplayAllTeamsTeamIdAndAbrreviation {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			IplTeamsDao dao = new IplTeamsDaoImpl();
			dao.getAllTeamIdAndAbbreviation().forEach(t -> System.out.println(t.getTeamId() + " " + t.getNameAbbr()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
