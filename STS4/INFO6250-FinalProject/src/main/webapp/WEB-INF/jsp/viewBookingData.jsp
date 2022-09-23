<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="com.mycompany.pojo.Bus"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Booking Information</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset;border:100;border-color:black;border-width:20px;">
    <center>
        <h1>View All Booking Information</h1>
        <table class="table table-striped" border ="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>TicketRegNo.</th>
                <th>DateOfBooking</th>
                <th>NumberOfAdults</th>
                <th>NumberOfChildren</th>
                <th>Email</th>
                <th>Travel Date</th>
                <th>Bus Number</th>





            </tr>
            <c:forEach var="adv" items="${ticketList}">
                <tr>
                    <td>${adv.ticketRegistrationNumber}</td>
                    <td>${adv.dateOfBookingTicket}</td>
                    <td>${adv.numberOfAdults}</td>
                    <td>${adv.numberOfChildren}</td>
                    <td>${adv.emailAddress}</td>
                    <td>${adv.dateOfTravel}</td>
                    <td>${adv.busNumber}</td>




                </tr>
            </c:forEach>
     
    </table>
           
    <!--<a href="userLogin"> Go back to User page!</a>-->
    <a class="btn btn-success" href="javascript:history.back()">Back</a>
<!--    <a href ="welcomeUser.htm">Back</a>-->
</center>
</body>
</html>
