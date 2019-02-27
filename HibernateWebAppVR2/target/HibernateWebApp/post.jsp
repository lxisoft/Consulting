<%@ page import="java.util.*,com.lxisoft.byta.model.*"%>


 <html>
<body>

<%
User user=(User)session.getAttribute("users");%>
<% out.println("username is..........."+user.getName());%>
<form action="PostController" method="get" enctype="multipart/form-data">

<table border="0">
          <tr>
              <td>Description: </td>
              <td><input type="text" name="description" /></td>
          </tr>
         
          <tr>
              <td>Portrait Photo: </td>
              <td><input type="file" name="image"/></td>
          
        </tr>
        
         <input type="hidden" name="userid" value="<%=user.getId()%>"/>
         
    
          
              <td colspan="2">
                  <input type="submit" value="Save">
              </td>
          </tr>
      </table>
  </form>

</body></html>