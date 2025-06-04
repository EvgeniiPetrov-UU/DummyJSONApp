package com.example.dummyjsonapp.models.entity.product;

import com.example.dummyjsonapp.models.entity.user.User;
import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    @SequenceGenerator(
            name = "review_seq",
            sequenceName = "review_seq",
            allocationSize = 5
    )
    private Long id;
    private Byte rating;
    private String comment;
    private ZonedDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User reviewer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Review() {

    }

    public Review(Long id, Byte rating, String comment, ZonedDateTime date,
                  User reviewer, Product product) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        this.reviewer = reviewer;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getRating() {
        return rating;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (getClass() != obj.getClass())) return false;

        Review review = (Review) obj;

        return (review.id.equals(id)) && (review.rating.equals(rating))
                && (Objects.equals(review.comment, comment)) && (review.date.equals(date))
                && (review.reviewer.equals(reviewer)) && (review.product.equals(product));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, comment, date, reviewer, product);
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewer=" + reviewer.toString() +
                ", product=" + product.toString() +
                '}';
    }
}
