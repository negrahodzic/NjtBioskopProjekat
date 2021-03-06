
<%-- 
    Document   : searchMovies
    Created on : Aug 6, 2020, 6:09:51 PM
    Author     : remmi
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search movies</title>

    </head>
    <body>

        <div class="container">
            <form action="<c:url value="/searchMovies/search"/>" method="post">
                <br> <p/>
                <div class="row">
                    <div class="col-md-4">
                        <input class="form-control" type="text" placeholder="Search movie title" name="searchMovieTitle">
                    </div>
                    <div class="col-md-3">
                        <select name="selectedGenre" class="browser-default custom-select">
                            <option>- Choose genre -</option>
                            <c:forEach var="genre" items="${genres}">
                                <option>${genre.genreName}</option>
                            </c:forEach>
                        </select></div>
                    <div class="col-md-5">
                        <input type="submit" id="Search" value="Search" class="btn btn-outline-primary" onclick="myFunction()"/>
                    </div>
                </div>
                <p/>

            </form>
            <br>
            <div class="row">
                <c:forEach var="movie" items="${movies}" varStatus="loop">
                    <div class="col-md-4">
                        <div class="card" style="width: 20rem;">
                            <img src="<c:url value="/resources/images/${movie.image}.png"/>" class="card-img-top" alt="Here goes image" style="height: 12rem;">
                            <div class="card-body">
                                <h5 class="card-title">${movie.title}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">${movie.duration} min, 
                                    &nbsp;<span class="badge badge-dark">${movie.genre.genreName}</span>
                                    &nbsp;<a href="<c:url value="/searchMovies/${movie.movieId}/seeReviews"/>" class="card-link">Reviews</a>
                                </h6>
                                <p class="card-text">${movie.description}</p>
                                <div class="text-center">
                                    <a href="<c:url value="/searchMovies/${movie.movieId}/seeProjections"/>" class="btn btn-outline-primary">See projections</a>
                                </div>
                            </div>
                        </div>
                        <p/>
                    </div>
                </c:forEach>
            </div>
        </div>
        <br>
        <br>
    </body>
</html>