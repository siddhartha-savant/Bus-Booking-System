<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="com.mycompany.pojo.Bus"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Bus Information</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset;border:100;border-color:black;border-width:20px;">
    <center>
        <h1>All Bus Routes are as follows:</h1>
        <table class="table table-striped" border ="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>Bus No.</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Total Seats</th>
                <th>Departure Date</th>


            </tr>
            <c:forEach var="adv" items="${busList}">
                <tr>
                    <td>${adv.busNumber}</td>
                    <td>${adv.sourceLocation}</td>
                    <td>${adv.destinationLocation}</td>
                    <td>${adv.totalSeatsAvailable}</td>
                    <td>${adv.departureDate}</td>



                </tr>
            </c:forEach>
    </center>
</table>

        <a class="btn btn-primary" href="welcomeUser.htm">Back</a>
        <br/>
</body>
</html>
