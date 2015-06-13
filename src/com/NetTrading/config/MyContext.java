package com.NetTrading.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;


public class MyContext {
	public static WebApplicationContext WebAppContext  ;
	public static ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext("spring_db.xml");


	
}
