<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : myReservations
    Created on : Aug 6, 2020, 6:11:52 PM
    Author     : remmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My reservations</title>
        <style>
            #snackbar {
                visibility: hidden;
                min-width: 250px;
                margin-left: -125px;
                background-color: #333;
                color: #fff;
                text-align: center;
                border-radius: 2px;
                padding: 16px;
                position: fixed;
                z-index: 1;
                left: 50%;
                bottom: 60px;
                font-size: 17px;
            }

            #snackbar.show {
                visibility: visible;
                -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
                animation: fadein 0.5s, fadeout 0.5s 2.5s;
            }

            @-webkit-keyframes fadein {
                from {bottom: 0; opacity: 0;} 
                to {bottom: 60px; opacity: 1;}
            }

            @keyframes fadein {
                from {bottom: 0; opacity: 0;}
                to {bottom: 60px; opacity: 1;}
            }

            @-webkit-keyframes fadeout {
                from {bottom: 6px; opacity: 1;} 
                to {bottom: 0; opacity: 0;}
            }

            @keyframes fadeout {
                from {bottom: 60px; opacity: 1;}
                to {bottom: 0; opacity: 0;}
            }
        </style>
    </head>
    <body>
        <div class="container">
            <br> <br>
            <table class="table table-hover text-center">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Movie</th>
                        <th scope="col">Projection date</th>
                        <th scope="col">Room</th>
                        <th scope="col">Tickets</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="reservation" items="${reservations}" varStatus="loop">  
                        <tr>

                            <th scope="row">${loop.index+1}</th>
                            <td >${reservation.projection.movie.title}</td>
                            <td>${reservation.projection.dateTimeOfProjection}</td>
                            <td>${reservation.projection.room.roomName}</td>
                            <td>${reservation.ticketQuantity}</td>
                            <td> 
                                <c:choose>
                                    <c:when test="${'active' eq reservation.status}">
                                        <a href="#" class="btn btn-outline-danger btn-block"  data-toggle="modal" data-target="#exampleModalCenter" data-bookid="@book.Id" >Delete</a>
                                    </c:when>    
                                    <c:otherwise>
                                        Expired
                                    </c:otherwise>
                                </c:choose>
                            </td>


                        </tr>

                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Delete reservation</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body text-center">
                                    Do you want to delete your reservation for <br>
                                    ${reservation.projection.movie.title} at ${reservation.projection.dateTimeOfProjection} ?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                                    <a href="<c:url value="/myReservations/${reservation.reservationId}/delete"/>" class="btn btn-outline-danger" onclick="myFunction()"  >Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                </tbody>
            </table>
        </div>

        <div id="snackbar">${sessionScope.message}</div>

        <c:if test="${not empty sessionScope.message}">
            <script>
                var x = document.getElementById("snackbar");
                x.className = "show";
                setTimeout(function () {
                    x.className = x.className.replace("show", "");
                }, 3000);
            </script>
            <c:set var = "message" value = "" scope="session"/>
        </c:if>   
    </body>
</html>
