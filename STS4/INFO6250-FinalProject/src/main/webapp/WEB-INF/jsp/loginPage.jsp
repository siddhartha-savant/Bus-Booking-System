<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center" style="border-style:inset; border:50; border-color:black; border-width:15px;">
    <center>
        <h1>Enter Login Credentials:</h1>

        <form:form modelAttribute="user">
            <table>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="emailAddress" size="30" /> <font color="red"><form:errors path="emailAddress"/></font></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
                </tr>

                
            </table>
                
            <input class="btn btn-primary" type="submit" value="Login" />
    
            <br>
        </form:form>
    
    </br> 
    <a class="btn btn-success" href="userRegister.htm"> Register </a>
    <a class="btn btn-primary" href="index.htm"> Main Page </a>
    
    </br>
    </center>

</body>
</html>
