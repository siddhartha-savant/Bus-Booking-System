<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Bus Data</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset; border:50; border-color:black; border-width:15px;">
        <center>
        <h1>Add New Bus Data</h1>
 
        <form:form modelAttribute="bus">

            <table>
                <tr>
                    <td>Bus Number:</td>
                    <td><form:input path="busNumber" size="30"/> <font color="red"><form:errors path="busNumber"/></font></td>
                </tr>

                <tr>
                    <td>Source:</td>
                    <td><form:input path="sourceLocation" size="30"/> <font color="red"><form:errors path="sourceLocation"/></font></td>
                </tr>

                <tr>
                    <td>Destination:</td>
                    <td><form:input path="destinationLocation" size="30"/> <font color="red"><form:errors path="destinationLocation"/></font></td>
                </tr>

                <tr>
                    <td>Total Seats:</td>
                    <td><form:input path="totalSeatsAvailable" size="30"/> <font color="red"><form:errors path="totalSeatsAvailable"/></font></td>
                </tr>

                <tr>
                    <td>Departure Date: </td>
                    <td><form:input path="departureDate" size="30"/> <font color="red"><form:errors path="departureDate"/></font></td>
                </tr>
        </table>
            <br>
            <input class="btn btn-success" type="submit" value="Add Bus Details"/>
          

        </form:form>
        </center>
    <br/>
</body>
</html>
