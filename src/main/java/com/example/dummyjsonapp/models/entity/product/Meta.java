package com.example.dummyjsonapp.models.entity.product;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "meta_data")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meta_seq")
    @SequenceGenerator(
            name = "meta_seq",
            sequenceName = "meta_seq",
            allocationSize = 5
    )
    private Long id;
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    private String barcode;
    private String qrCode;

    public Meta() {

    }

    public Meta(Long id, Instant createdAt, Instant updatedAt,
                String barcode, String qrCode) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.barcode = barcode;
        this.qrCode = qrCode;
    }

    /*
    Этот метод обратного вызова перед созданием сущности должен проверить
    проинициализировано ли уже поле (это может произойти, если DTO объект Meta
    конвертируется в сущность, то есть сущность Product импортируется с помощью
    стороннего API и является уже полностью готовой). Если поле не проинициали-
    зировано, то создается новая сущность Product, поэтому нужно проинициализи-
    ровать это поле автоматически.
     */
    @PrePersist
    private void prePersist() {
        if ((this.createdAt == null) && (this.updatedAt == null)) {
            this.createdAt = Instant.now();
            this.updatedAt = Instant.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;
        Meta meta = (Meta) o;
        return (id.equals(meta.id)) && (createdAt.equals(meta.createdAt));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt);
    }

    @Override
    public String toString() {
        return "Meta{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                "}";
    }
}
