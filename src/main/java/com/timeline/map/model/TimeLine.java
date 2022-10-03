package com.timeline.map.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class TimeLine {

    @Id
    @Column(name = "tl_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 18, scale = 10, nullable = false)
    private BigDecimal latitude;

    @Column(precision = 18, scale = 10, nullable = false)
    private BigDecimal longitude;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column
    private LocalDateTime regDate;

    @PrePersist
    private void prePersist() {
        this.regDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "TimeLine{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", regDate=" + regDate +
                '}';
    }
}
