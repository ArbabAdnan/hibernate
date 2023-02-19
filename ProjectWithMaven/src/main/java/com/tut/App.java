package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "project started..." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(111);
        st.setName("arbab kasi");
        st.setCity("islamabad");
        System.out.println(st);
        
        //creating obj of address class
        
        Address address = new Address();
        
        
        address.setStreet("street1");
        address.setCity("karchi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(12.333);
        
        //reading image
        FileInputStream fi= new FileInputStream("src/main/java/profile.png");
        byte[] data = new byte[fi.available()];
        fi.read(data);
        address.setImage(data);
        
        Session Session = factory.openSession();
        //
        Transaction tx = Session.beginTransaction();
        
        Session.save(st);
        Session.save(address);
        
        tx.commit();
        
        Session.close();
        System.out.println("Done");
       
        System.out.println(factory.isClosed());
    }
}
