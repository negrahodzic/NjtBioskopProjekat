/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.njt.webapp.njtbioskopprojekat.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rs.njt.webapp.njtbioskopprojekat.dto.UserDto;
import rs.njt.webapp.njtbioskopprojekat.service.MovieService;
import rs.njt.webapp.njtbioskopprojekat.service.ReviewService;

/**
 *
 * @author Negra Hodžić 221/16 & Marko Cvijović 168/16
 */
@Controller
@RequestMapping(path = "/reviews")
public class ReviewsController {

    private final MovieService movieService;
    private final ReviewService reviewService;
    private final ModelAndView modelAndView;

    @Autowired
    public ReviewsController(MovieService movieService, ReviewService reviewService) {
        this.movieService = movieService;
        this.reviewService = reviewService;
        this.modelAndView = new ModelAndView();
    }

    @GetMapping
    public ModelAndView reviews() {
        modelAndView.setViewName("reviews");
        return modelAndView;
    }

    @PostMapping(path = "/{movieId}/save")
    public ModelAndView saveReview(@PathVariable(name="movieId") Long movieId, HttpServletRequest request) { 
        String grade = request.getParameter("grade");
        int gradeInt = Integer.parseInt(grade);
        
        String comment = request.getParameter("comment");   
        
        UserDto user = (UserDto) request.getSession(true).getAttribute("loggedUser");
        
        reviewService.saveReview(movieId, gradeInt, comment, user);
        
        modelAndView.setViewName("reviews");
        modelAndView.addObject("movieDto", movieService.getById(movieId));
        request.getSession(true).setAttribute("message", "Review successfully saved!");
        return modelAndView;
    }

}
