package com.example.dummyjsonapp.models.entity.product;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "dimensions")
public class Dimensions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dimensions_seq")
    @SequenceGenerator(
            name = "dimensions_seq",
            sequenceName = "dimensions_seq",
            allocationSize = 5

    )
    private Long id;
    private Double width;
    private Double height;
    private Double depth;

    public Dimensions() {

    }

    public Dimensions(Long id, Double width, Double height, Double depth) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (getClass() != obj.getClass())) return true;
        Dimensions dimensions = (Dimensions) obj;
        return (dimensions.id.equals(id)) && Objects.equals(dimensions.width, width)
                && Objects.equals(dimensions.height, height)
                && Objects.equals(dimensions.depth, depth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, width, height, depth);
    }

    @Override
    public String toString() {
        return "Dimensions{" +
                "id=" + id +
                ", width=" + width +
                ", height" + height +
                ", depth=" + depth +
                "}";
    }
}
