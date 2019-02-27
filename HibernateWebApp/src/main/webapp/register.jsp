
<%@ page import="com.lxisoft.byta.UserDAO"%>
<jsp:useBean id="obj" class="com.lxisoft.byta.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>


<%
int i=UserDAO.register(obj);
if(i>0)
out.print("sucessfully inserted");
%>
