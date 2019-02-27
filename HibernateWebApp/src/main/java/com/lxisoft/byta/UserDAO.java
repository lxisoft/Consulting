package com.lxisoft.byta;

import javax.persistence.Query;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserDAO {
	public static int register(User u){    
		   
		 int i=0;    
		  
		 StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		 
		 SessionFactory factory=meta.getSessionFactoryBuilder().build();
		 Session session=factory.openSession();
		 Transaction t=session.beginTransaction();
		 
		 i=(Integer)session.save(u);
		 t.commit();
		 session.close();
		 
		 
		 
		/* StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		  
		i=(Integer)session.save(u);    
		  
		t.commit();    
		session.close();   */ 
		    
		return i;   
}
	
	
	public static  User getUserByUserId(int userId) {
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
	      SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();
		 
      
       Transaction tx = null;
       User user = null;
       try {
           tx = session.getTransaction();
           tx.begin();
          /* Query query = session.createQuery("select from User2 where id='"+userId+"'");
           user = (User)((org.hibernate.Query) query).uniqueResult();*/
           user = (User)session.get(User.class, userId);
           
           
           tx.commit();
       } catch (Exception e) {
           if (tx != null) {
               tx.rollback();
           }
           e.printStackTrace();
       } finally {
           session.close();
       }
       return user;
   }
	
	
	
	
}
