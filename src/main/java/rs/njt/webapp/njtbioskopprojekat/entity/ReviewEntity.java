/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.njt.webapp.njtbioskopprojekat.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Negra Hodžić 221/16 & Marko Cvijović 168/16
 */
@Entity
@Table(name = "REVIEW")
public class ReviewEntity implements Serializable {

    @EmbeddedId
    private ReviewId reviewId;

    private int grade;
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("MOVIE_ID")
    private MovieEntity movie;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("USER_ID")
    private UserEntity user;

    public ReviewEntity() {
    }

    public ReviewEntity(MovieEntity movie, UserEntity user) {
        this.user = user;
        this.movie = movie;
        this.reviewId = new ReviewId(movie.getMovieId(), user.getUserId());
    }

    public ReviewEntity(int grade, String comment) {
        this.grade = grade;
        this.comment = comment;
    }

    public ReviewEntity(ReviewId reviewId, int grade, String comment, MovieEntity movie, UserEntity user) {
        this.reviewId = reviewId;
        this.grade = grade;
        this.comment = comment;
        this.movie = movie;
        this.user = user;
    }

    public ReviewEntity(ReviewId reviewId, int grade, String comment) {
        this.reviewId = reviewId;
        this.grade = grade;
        this.comment = comment;
    }

    public ReviewEntity(int grade, String comment, MovieEntity movie, UserEntity user) {
        this.grade = grade;
        this.comment = comment;
        this.movie = movie;
        this.user = user;
    }

    
    public ReviewId getReviewId() {
        return reviewId;
    }

    public void setReviewId(ReviewId reviewId) {
        this.reviewId = reviewId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ReviewEntity{" + "reviewId=" + reviewId + ", grade=" + grade + ", comment=" + comment +  '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.reviewId);
        hash = 29 * hash + this.grade;
        hash = 29 * hash + Objects.hashCode(this.comment);
        hash = 29 * hash + Objects.hashCode(this.movie);
        hash = 29 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReviewEntity other = (ReviewEntity) obj;
        if (this.grade != other.grade) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.reviewId, other.reviewId)) {
            return false;
        }
        if (!Objects.equals(this.movie, other.movie)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

}
