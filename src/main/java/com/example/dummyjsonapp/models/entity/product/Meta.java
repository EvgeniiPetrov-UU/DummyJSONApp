package com.example.dummyjsonapp.models.entity.product;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
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
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String barcode;
    private String qrCode;

    public Meta() {

    }

    public Meta(Long id, ZonedDateTime createdAt, ZonedDateTime updatedAt,
                String barcode, String qrCode) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.barcode = barcode;
        this.qrCode = qrCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (getClass() != obj.getClass())) return false;
        Meta meta = (Meta) obj;
        return (meta.id.equals(id)) && (meta.createdAt.equals(createdAt))
                && (meta.updatedAt.equals(updatedAt)) && (meta.barcode.equals(barcode))
                && (meta.qrCode.equals(qrCode));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, barcode, qrCode);
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
