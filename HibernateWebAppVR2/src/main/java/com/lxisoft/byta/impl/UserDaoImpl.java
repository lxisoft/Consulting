package com.lxisoft.byta.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.lxisoft.byta.model.User;

public class UserDaoImpl implements UserDAO {
	
	public void register(User u){    
		   
	     StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		 
		 SessionFactory factory=meta.getSessionFactoryBuilder().build();
		 Session session=factory.openSession();
		 Transaction t=session.beginTransaction();
		 
		 session.save(u);
		 t.commit();
		 session.close();
		 
		 
	}
	
	
	public  User getUserByUserId(int userId) {
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
          Query query = session.createQuery("from User where id='"+userId+"'");
          //user = (User)((org.hibernate.Query) query).uniqueResult();
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
	
	@SuppressWarnings("deprecation")
	public static List<User> showAllUsers(){
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
	      SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();
		 
     List<User>user=new ArrayList<User>();
      Transaction tx = null;
     // User user = null;
      try {
          tx = session.getTransaction();
          tx.begin();
          Query query = session.createQuery("from User");
         user=((org.hibernate.Query) query).list();
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


	public void updateUser(int id1, String uname, String uemail) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
	      SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();
		 
  // List<User>user=new ArrayList<User>();
    Transaction tx = null;
   // User user = null;
    try {
        tx = session.getTransaction();
        tx.begin();
        User user = (User)session.load(User.class, id1);
        user.setName(uname);
        user.setEmail(uemail);
        session.update(user);
        
     
        tx.commit();
        
	 } catch (Exception e) {
     if (tx != null) {
         tx.rollback();
     }
     e.printStackTrace();
 } finally {
     session.close();
 }
	}
	
	
	
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
	      SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();
		 
  // List<User>user=new ArrayList<User>();
    Transaction tx = null;
   // User user = null;
    try {
        tx = session.getTransaction();
        tx.begin();
       
        session.delete(user);
        
     
        tx.commit();
        
	 } catch (Exception e) {
     if (tx != null) {
         tx.rollback();
     }
     e.printStackTrace();
 } finally {
     session.close();
 }
	}





	




	


}
