/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.njt.webapp.njtbioskopprojekat.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Negra Hodžić 221/16 & Marko Cvijović 168/16
 */
@Entity
@Table(name = "MOVIE")
public class MovieEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long movieId;
    private String title;
    private String description;
    private int duration;
    private String image;
    
    @ManyToOne(fetch = FetchType.EAGER) // Note: U nasem slucaju, film ima samo jedan zanr 
    @JoinColumn(name = "GENRE_ID", referencedColumnName = "GENRE_ID")
    private GenreEntity genre;
    
    @OneToMany(
        mappedBy = "movie",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.EAGER
    )
    private List<ReviewEntity> reviews = new ArrayList<>();
    
    public MovieEntity() {
    }

    public MovieEntity(Long movieId, String title, String description, int duration, String image, GenreEntity genre) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.image = image;
        this.genre = genre;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }
    
    public void addReviewUser(UserEntity user, ReviewEntity review) {
//        ReviewEntity review = new ReviewEntity(this, user);
        review.setMovie(this);
        review.setUser(user);
        reviews.add(review);
        user.getReviews().add(review);
    }
 

//    public void addTag(Tag tag) {
//        PostTag postTag = new PostTag(this, tag);
//        tags.add(postTag);
//        tag.getPosts().add(postTag);
//    }
// 
//    public void removeTag(Tag tag) {
//        for (Iterator<PostTag> iterator = tags.iterator();
//             iterator.hasNext(); ) {
//            PostTag postTag = iterator.next();
// 
//            if (postTag.getPost().equals(this) &&
//                    postTag.getTag().equals(tag)) {
//                iterator.remove();
//                postTag.getTag().getPosts().remove(postTag);
//                postTag.setPost(null);
//                postTag.setTag(null);
//            }
//        }
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.movieId);
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + this.duration;
        hash = 83 * hash + Objects.hashCode(this.image);
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
        final MovieEntity other = (MovieEntity) obj;
        if (this.duration != other.duration) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.movieId, other.movieId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovieEntity{" + "movieId=" + movieId + ", title=" + title + ", description=" + description + ", duration=" + duration + ", image=" + image + '}';
    }
 
    
    
}
