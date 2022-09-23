<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="com.mycompany.pojo.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All User Information</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset;border:100;border-color:black;border-width:20px;">
    <center>
        <h1>View All User Information</h1>
        <table class="table table-striped" border ="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>Email</th>
                <th>Password</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Contact Number</th>
                <th>Age</th>




            </tr>
            <c:forEach var="adv" items="${userList}">
                <tr>
                    <td>${adv.emailAddress}</td>
                    <td>${adv.password}</td>
                    <td>${adv.userName}</td>
                    <td>${adv.gender}</td>
                    <td>${adv.contactNumber}</td>
                    <td>${adv.age}</td>

                </tr>
            </c:forEach>
                
                
    </center>
</table>
        <a class="btn btn-primary" href="welcomeAdmin.htm" > Back to Main Menu</a><!-- comment -->
</body>
</html>
