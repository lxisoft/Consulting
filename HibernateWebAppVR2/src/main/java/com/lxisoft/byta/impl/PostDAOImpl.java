package com.lxisoft.byta.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.lxisoft.byta.model.Post;
import com.lxisoft.byta.model.User;

public class PostDAOImpl implements PostDAO {
	public void save(Post post)
	{
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		 
		 SessionFactory factory=meta.getSessionFactoryBuilder().build();
		 Session session=factory.openSession();
		 Transaction t=session.beginTransaction();
		 session.save(post);
		 
		
		 t.commit();
		 session.close();
		 
		
		System.out.print("post is "+post.getUser().getId());
		 
	}
	
	

}
