<%@ page import="com.lxisoft.byta.UserDAO, com.lxisoft.byta.User" %>
<jsp:useBean id="obj" class="com.lxisoft.byta.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>
<%
User user=UserDAO.getUserByUserId(obj.getId());
out.println(user.getName());
%>