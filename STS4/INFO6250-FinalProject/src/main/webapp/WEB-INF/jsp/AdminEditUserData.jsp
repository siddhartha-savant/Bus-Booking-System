<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User Data</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset;border:100;border-color:black;border-width:20px;">
    <center>
        <h1>Hi Admin!</h1>
<h3>You can edit user data below:</h3>
        <form:form modelAttribute="user">

            <table>

               
                <h6>Please enter Original Email: <form:input path="emailAddress" size="30" /> <font color="red"><form:errors path="emailAddress"/></font></h6>
                

                <br/><!-- comment -->
                <br/>
                
                 <h2>Enter Data to be Updated:</h2>
                <tr>
                    <td>Password: </td>
                    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
                </tr>

                <tr>
                    <td>Name: </td>
                    <td><form:input path="userName" size="30" /> <font color="red"><form:errors path="userName"/></font></td>
                </tr>

                <tr>
                    <td>Gender: </td>
                    <td><form:input path="gender" size="30" /> <font color="red"><form:errors path="gender"/></font></td>
                </tr>

                <tr>
                    <td>Contact No: </td>
                    <td><form:input path="contactNumber" size="30" /> <font color="red"><form:errors path="contactNumber"/></font></td>
                </tr>

                <tr>
                    <td>Age: </td>
                    <td><form:input path="age" size="30" /> <font color="red"><form:errors path="age"/></font></td>
                </tr>
                

            </table>
            <br>
            <input class="btn btn-success" type="submit" value="Update User Info" />

        </form:form>
    </center>
</body>
</html>
