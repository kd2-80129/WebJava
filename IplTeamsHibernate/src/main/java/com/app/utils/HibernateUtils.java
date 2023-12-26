package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	//static init block to create a singleton factory SF
	//Configuration --> configure --> buildSessionFactory
	static {
		System.out.println("in static init block");
		factory = new Configuration()//empty configuration created
				.configure()//reads hibernate config xml file n populates the config
				.buildSessionFactory();//builds instance of SF from the populated config
		System.out.println("Session Factory created");
	}

	public static SessionFactory getFactory() {
		return factory;
	}
	
}
