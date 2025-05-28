package com.example.dummyjsonapp.models.entity.user;

import com.example.dummyjsonapp.models.entity.Review;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            allocationSize = 5
    )
    private Long id;
    private String name;
    private String surname;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    public User() {

    }

    public User(Long id, String name, String surname, String email,
                List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name)
                && surname.equals(user.surname)
                && email.equals(user.email)
                && Objects.equals(reviews, user.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, reviews);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", surname=" + surname +
                ", email=" + email +
                "}";
    }
}
