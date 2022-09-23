<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Bus Data!</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset;border:100;border-color:black;border-width:15px;">
    <center>
        <h1>Do you want to delete the Bus Route?</h1>

        <form:form modelAttribute="bus">
            <table>
                <tr>
                    <td>Bus Number:</td>
                    <td><form:input path="busNumber" size="30" /> <font color="red"><form:errors path="busNumber"/></font></td>
                </tr>

                </table>
                <br>
            <input class="btn btn-danger" type="submit" value="Delete" />
        
        </form:form>
    </center>
    <br/>
</body>
</html>
