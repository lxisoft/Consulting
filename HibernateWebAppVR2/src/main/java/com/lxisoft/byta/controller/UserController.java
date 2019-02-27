package com.lxisoft.byta.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lxisoft.byta.impl.UserDAO;
import com.lxisoft.byta.impl.UserDaoImpl;
import com.lxisoft.byta.model.User;
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	User user=new User();
  UserDaoImpl impl=new UserDaoImpl();
	final static Logger logger = Logger.getLogger(UserController.class);
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
        	if(request.getParameter("addUser")!=null){
        		
        		logger.info("in user controller..........");
        
            String uname = request.getParameter("uname");
            String upass = request.getParameter("upass");
            String uemail = request.getParameter("uemail");
            user.setName(uname);
            user.setPassword(upass);
            user.setEmail(uemail);           
           // user.setId(id);
            impl.register(user);
            HttpSession session=request.getSession();
            session.setAttribute("users", user);
          RequestDispatcher rd = request.getRequestDispatcher("post.jsp");
            rd.include(request, response);
        }
        }
        catch (Exception e) {
		
			logger.debug("exception caughts");
			
		}
}
	
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	          
		 try
		 {
		 if(request.getParameter("showUser")!=null){
	            List<User> userList = new ArrayList();
	            userList = impl.showAllUsers();
	            logger.info(userList.get(0).getName());
	          
	            request.setAttribute("usersList", userList);
	            RequestDispatcher rd = request.getRequestDispatcher("showAll.jsp");
	            rd.forward(request, response);
	        }
	         
	          if(request.getParameter("updateUser")!=null){
	             int id1 = Integer.parseInt(request.getParameter("id"));
	             String uname = request.getParameter("uname");
	             String uemail = request.getParameter("uemail");
	             impl.updateUser(id1, uname,uemail);
	             
	             RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	             rd.forward(request, response);
	             
	         }
	          
	         if(request.getParameter("deleteUser")!=null){
	             int id2 = Integer.parseInt(request.getParameter("id"));
	             user.setId(id2);
	             impl.deleteUser(user);
	              RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	         }
	         
	      
		 }catch (Exception e) {
			logger.info("exception in post");
		}
         }
}
