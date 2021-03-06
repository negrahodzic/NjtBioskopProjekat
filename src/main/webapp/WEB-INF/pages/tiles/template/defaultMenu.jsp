<%-- 
    Document   : menu
    Created on : Aug 6, 2020, 4:48:54 PM
    Author     : remmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>

        <div class="container">

            <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top d-flex justify-content-center">
                <!-- Brand -->
                <a class="navbar-brand" href="#">NJT CINEMA</a>

                <!-- Links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/searchMovies"/>">Search movies</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/searchProjections"/>">Search projections</a>
                    </li>
                    <c:choose>
                        <c:when test="${not empty loggedUser}">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/myReservations"/>">My reservations</a>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                    My profile
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="<c:url value="/editProfile"/>">Edit profile</a>
                                    <a class="dropdown-item" href="<c:url value="/logout"/>">Logout</a>
                                </div>
                            </li>
                        </ul>  
                        <div class="text-light">&nbsp;&nbsp;&nbsp; Hello, ${loggedUser.username}! </div><br> 

                    </c:when>
                    <c:otherwise>
                        <li class="nav-item text-light">
                            <a class="nav-link text-light" href="<c:url value="/register"/>">Register</a>
                        </li>
                        <li class="nav-item text-light">
                            <a class="nav-link text-light" href="<c:url value="/landing"/>">Login</a>
                        </li>
                        </ul>  
                    </c:otherwise>
                </c:choose>
            </nav>                  
        </div>
    </body>
</html>



