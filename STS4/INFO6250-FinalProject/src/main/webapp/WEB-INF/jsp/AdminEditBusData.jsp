<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Bus Data</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset;border:100;border-color:black;border-width:20px;">
    <center>
        <h1>Edit Bus Details:</h1>
<h3>You can edit Bus route details below:</h3>
        <form:form modelAttribute="bus">

            <table>
                
                <h6>Enter Original Bus Number First: <form:input path="busNumber" size="30" /> <font color="red"><form:errors path="busNumber"/></font></h6>
                

                <br/>
                <br/>
                
                 <h2>Enter Data to be Updated:</h2>


                <tr>
                    <td>Source:</td>
                    <td><form:input path="sourceLocation" size="30" /> <font color="red"><form:errors path="sourceLocation"/></font></td>
                </tr>

                <tr>
                    <td>Destination:</td>
                    <td><form:input path="destinationLocation" size="30" /> <font color="red"><form:errors path="destinationLocation"/></font></td>
                </tr>

                <tr>
                    <td>Total Seats:</td>
                    <td><form:input path="totalSeatsAvailable" size="30" /> <font color="red"><form:errors path="totalSeatsAvailable"/></font></td>
                </tr>
                
                <tr>
                    <td>Departure Date:</td>
                    <td><form:input path="departureDate" size="30" /> <font color="red"><form:errors path="departureDate"/></font></td>
                </tr>
            </table>
            <br>
            <input class="btn btn-success" type="submit" value="Add Bus Details" />
           
            
        </form:form>

        <a class="btn btn-primary" href ="welcomeAdmin.htm">Back to Main Menu</a>
        
    </center>
     <br/>
</body>
</html>
