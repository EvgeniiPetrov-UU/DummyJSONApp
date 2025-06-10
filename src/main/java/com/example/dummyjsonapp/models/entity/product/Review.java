package com.example.dummyjsonapp.models.entity.product;

import com.example.dummyjsonapp.models.entity.user.User;
import jakarta.persistence.*;
import org.hibernate.HibernateException;

import java.time.Instant;
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
    @Column(updatable = false)
    private Instant date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false)
    private User reviewer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", updatable = false)
    private Product product;

    public Review() {

    }

    public Review(Long id, Byte rating, String comment, Instant date,
                  User reviewer, Product product) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        this.reviewer = reviewer;
        this.product = product;
    }

    //При создании нового пользователем нового отзыва записывается текущее время
    @PrePersist
    private void prePersist() {
        if (this.date == null) {
            this.date = Instant.now();
        }
    }

    //Этот метод нужен для защиты от LazyInitializationException
    protected String getReviewerEmail() {
        if (reviewer == null) return null;
        try {
            return reviewer.getEmail();
        } catch (HibernateException e) {
            return null; //Можно выбросить свое исключение, хотя надо подумать
        }
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

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public User getReviewer() {
        return reviewer;
    }

    //Сеттер только для Hibernate
    protected void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;
        Review review = (Review) o;
        return (rating.equals(review.rating)) &&
                (date.equals(review.date)) &&
                Objects.equals(getReviewerEmail(), review.getReviewerEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, date, getReviewerEmail());
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
