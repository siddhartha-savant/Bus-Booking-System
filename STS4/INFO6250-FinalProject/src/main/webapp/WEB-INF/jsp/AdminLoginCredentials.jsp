<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset; border:50; border-color:black; border-width:15px;">
        
    <center>
        <h1>Admin Login Page</h1>
        <form:form modelAttribute="admin">
            <table>
                <tr>
                    <td>Admin Email: </td>
                    <td><form:input path="emailID" size="30" /> <font color="red"><form:errors path="emailID"/></font></td>
                </tr>

                <tr>
                    <td>Password: </td>
                    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
                </tr>
                
            </table>
            <br>
             <input class="btn btn-success" type="submit" value="Login" />
        </form:form>        
    </center>



</body>
</html>
