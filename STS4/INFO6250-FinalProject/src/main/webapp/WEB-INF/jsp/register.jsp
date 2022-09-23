<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Register a New User!</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset; border:50; border-color:black; border-width:15px;">
        <center>
        <h2>Register a New User</h2>
    
        <form:form modelAttribute="user">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="emailAddress" size="30" type="email" required="required"/> <font color="red"><form:errors path="emailAddress"/></font></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" size="30" required="required"/> <font color="red"><form:errors path="password"/></font></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="userName" size="30" required="required"/> <font color="red"><form:errors path="userName"/></font></td>
                </tr>

                <tr>
                    <td>Gender</td>
                    <td><form:input path="gender" size="30" required="required"/> <font color="red"><form:errors path="gender"/></font></td>
                </tr>

                <tr>
                    <td>Contact</td>
                    <td><form:input path="contactNumber" size="30" required="required" /> <font color="red"><form:errors path="contactNumber"/></font></td>
                </tr>

                <tr>
                    <td>Age:</td>
                    <td><form:input path="age" size="30" required="required"/> <font color="red"><form:errors path="age"/></font></td>
                </tr>


                
            </table>
                
                <input class="btn btn-success" type="submit" value="Register"/>
      
            <br>

        </form:form>
    <a class="btn btn-primary" href="userLogin.htm"> Login </a>
    <a class="btn btn-primary" href="index.htm"> Main Page </a>  
</center>


</body>
</html>