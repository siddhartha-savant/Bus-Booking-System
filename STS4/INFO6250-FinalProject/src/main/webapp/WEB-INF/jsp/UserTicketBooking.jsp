<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Tickets here!</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset; border:50; border-color:black; border-width:15px;">
<center>
        <h1>Ticket Booth</h1>
    <h5>Fill details to Book bus ticket</h5>
        <form:form modelAttribute="ticket">
            <table>
                <tr>
                    <td>Bus Number:</td>
                    <td><form:input path="busNumber" size="30" /> <font color="red"><form:errors path="busNumber"/></font></td>
                </tr>

                <tr>
                    <td>Travel Date</td>
                    <td><form:input path="dateOfTravel" size="30" /> <font color="red"><form:errors path="dateOfTravel"/></font></td>
                </tr>

                <tr>
                    <td>Adult Count</td>
                    <td><form:input path="numberOfAdults" size="30" /> <font color="red"><form:errors path="numberOfAdults"/></font></td>
                </tr>

                <tr>
                    <td>Child Count</td>
                    <td><form:input path="numberOfChildren" size="30" /> <font color="red"><form:errors path="numberOfChildren"/></font></td>
                </tr>

                <tr>
                    <td>Enter Email</td>
                    <td><form:input path="emailAddress" size="30" /> <font color="red"><form:errors path="emailAddress"/></font></td>
                </tr>
   </table>
 <br>
                <input class="btn btn-success" type="submit" value="Book Ticket"/>
 
        </form:form>
    </center>
</body>
</html>
