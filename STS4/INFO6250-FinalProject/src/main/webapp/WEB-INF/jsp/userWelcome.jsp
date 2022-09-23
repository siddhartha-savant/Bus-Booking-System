<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome User</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"  style="border-style:inset;border:100;border-color:black;border-width:20px;">
    <center>
        <h1>Welcome!</h1></br>
        
        <h5> View a Bus Route: <a class="btn btn-primary" href="viewBusUser.htm">View All Bus Information</a>        </h5>  
        <h5> You can book tickets now: <a class="btn btn-primary"href="bookTicket.htm"> Book Ticket </a> </h5> </br>
        <h5> View All Bookings: <a class="btn btn-primary" href="viewAllBookings.htm"> Show All Bookings </a>  </h5>  </br>
        <h5> Delete a previous booking: <a class="btn btn-primary" href="deleteTicket.htm"> Delete Booking </a>  </h5></br></br></br>
        
        <h5> Update User Info: <a class="btn btn-primary" href="updateUserInfo.htm">Update Account  </a>  </h5></br>
        <h5> For Account Closure: <a class="btn btn-danger" href="closeAccount.htm">Close Account  </a> </h5></br>


        <a class="btn btn-success" href="logout.htm"> Logout </a> 
        </center>
    </body>
</html>
