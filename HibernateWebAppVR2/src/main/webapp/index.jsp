
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <body>
        <div id="add">
        <h1> Add User </h1>
        <form action="UserController" method="get">
            <table>
             <tr>
                    <td> USER Name: </td>
                    <td><input type="text" name="uname"></td>
                </tr>
                <tr>
                    <td> USER PSSWORD: </td>
                    <td><input type="text" name="upass"></td>
                </tr>
                <tr>
                    <td> USER EMAIL: </td>
                   <td> <input type="email" name="uemail" placeholder="name@email.com" required /></td>
  
                </tr>
                <tr>
                    <td><input type="submit" name="addUser" value="Register"></td>
                </tr>
            </table>
        </form>
       
        <form action="post.jsp" method="post">
        <input type="submit" value="USER_POST"></form>
        
     
        
        
        <form action="UserController" method="POST">
            <input type="submit" name="showUser" value="Show"> &nbsp; &nbsp;<br>
            
            
        </form>
    </body>
</html>