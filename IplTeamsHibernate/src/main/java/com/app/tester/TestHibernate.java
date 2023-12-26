package com.app.tester;
import org.hibernate.*;
import static com.app.utils.HibernateUtils.getFactory;

public class TestHibernate {

	public static void main(String[] args) {
		//get the SF from utils
		try(SessionFactory sf = getFactory()){
			System.out.println("Hibernate Started Running!!");
		} //sf.close()-->Hibernate will auto clean up DBCP
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
