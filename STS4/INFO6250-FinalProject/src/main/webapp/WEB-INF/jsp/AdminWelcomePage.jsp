<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Admin!</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body align="center"   style="border-style:inset; border:50; border-color:black; border-width:15px;">
    <center>
        <h1>Welcome Admin!</h1>
        <h3>Here are the options for Buses</h3>
        <h5> Create a new Bus Route: <a class="btn btn-primary" href="createBus.htm"> Add New Bus </a></h5></br>
        <h5> View a Bus Route: <a class="btn btn-primary" href="viewBus.htm">View All Bus Information</a>        </h5>                </br>
        <h5> Update a given Bus Route: <a class="btn btn-primary" href="editBus.htm"> Update Bus Information </a>      </h5>                   </br>
        <h5> Delete a Bus Route: <a class="btn btn-danger" href="deleteBus.htm"> Delete Bus </a>             </h5>            </br>
        </br>
        </br>
        <h3>Here are the options for Users</h3>
        <h5> View all User's Information: <a class="btn btn-primary" href="viewAllUsers.htm"> View Every User's Information </a>           </h5>              </br>
        <h5> Update User Information: <a class="btn btn-primary" href="updateUser.htm"> Update User Information </a>                        </br>
        <h5> Delete a User: <a class="btn btn-danger" href="deleteUser.htm"> Delete User Account </a>                         </br></br></br>
        <a class="btn btn-danger" href="logout.htm"> Logout </a>                         </br>
</center>
    </body>
</html>
