package com.map1;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		
		 System.out.println( "project started..." );
	        

	        Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        
	        Emp emp1 = new Emp();
	        Emp emp2 = new Emp();
	        
	        emp1.setEid(34);
	        emp1.setName("adnan");
	        
	        emp2.setEid(35);
	        emp2.setName("farhan");
	        
	        Project p1=new Project();
	        Project p2=new Project();
	        
	        
	        p1.setPid(12121);
	        p1.setProjectName("library management system");
	        
	        p2.setPid(14214);
	        p2.setProjectName("Chatbot");
	        
	        
	        List<Emp> list1= new ArrayList<Emp>();
	        List<Project> list2 = new ArrayList<Project>();
	        
	        
	        list1.add(emp1);
	        list1.add(emp2);
	        
	        list2.add(p1);
	        list2.add(p2);
	        
	        //
	        emp1.setProjects(list2);
	        p2.setEmps(list1);
	        
	        Session s= factory.openSession();
	        org.hibernate.Transaction tx=s.beginTransaction();
	        
	        s.save(emp1);
	        s.save(emp2);
	        
	        s.save(p1);
	        s.save(p2);
	        
	        tx.commit();
	        
	        factory.close();
	}

}
