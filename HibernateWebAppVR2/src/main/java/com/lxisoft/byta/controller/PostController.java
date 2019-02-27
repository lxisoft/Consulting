package com.lxisoft.byta.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.LogManager;
import org.hibernate.annotations.common.util.impl.LoggerFactory;

import com.lxisoft.byta.impl.PostDAO;
import com.lxisoft.byta.impl.PostDAOImpl;
import com.lxisoft.byta.model.Post;
import com.lxisoft.byta.model.User;

@WebServlet("/PostController")
public class PostController extends HttpServlet{
	
	Post post=new Post();
	  
	PostDAO postImpl=new PostDAOImpl();
	
	final static org.apache.log4j.Logger logger = LogManager.getLogger(PostController.class);
	
	 public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	 {
		  PrintWriter out=res.getWriter();
		  logger.info("in post controller................");
		
	
	     User user=new User();
	  String description=req.getParameter("description");
		
		post.setDescription(description);
		logger.info(post.getDescription());
	
		 InputStream inputStream = null; // input stream of the upload file
         
	    
		
	        Part filePart = req.getPart("image");
	      
			logger.info("exception caught");
			
			post.setImage(filePart);
	        
	      //  user.setId(user_id);
	     // post.setUser(user);
	       
	 
	       post.setUser(user);
	        postImpl.save(post);
	       
	}

}
