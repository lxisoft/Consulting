

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
$(document).ready(function(){
    $("#delete").hide();
     $("#updateUser").hide();
    
    $("#update").click(function(){
        $("#updateUser").show();
        $("#deleteUser").hide();
    });
    $("#delete").click(function(){
        $("#deleteUser").show();
         $("#updateUser").hide();
    });
});
</script>
    </head>
    <body>
All USERS: <br> 
        <c:forEach var="user" items="${usersList}">
            User ID: ${user.id} <br>
            User Name: ${user.name} <br>
            User email: ${user.email}<br>
            -------------------------------------<br>
        </c:forEach>
        <form action="UserController" method="POST">
            Update: <input type="checkbox" id="update"> Delete: <input type="checkbox" id="delete" onclick="document.getElementById('uname').disabled=this.checked;document.getElementById('uemail').disabled=this.checked;"><br><br>
            <select name="id">
                <c:forEach items="${usersList}" var="user">
                <option value="${user.id}">${user.id}</option>
                 </c:forEach>
            </select>
            
            <br>
            Update Name: <input id="uname" type="text" name="uname"><br>
            Update Email: <input id="uemail" type="text" name="uemail"> <br><br>
            <button type="submit" id="updateUser" name="updateUser"> Update</button> <br> <br>
            <button type="submit" id="deleteUser" name="deleteUser"> Delete </button>
            
            </form>
    </body>
</html>