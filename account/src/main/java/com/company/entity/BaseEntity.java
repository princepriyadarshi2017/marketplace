package com.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;



@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {
    @Column(updatable = false)
    private LocalDate createdAt;

    private String createdBy;

    @Column(insertable = false)
    private LocalDateTime updatedAt;

    private String updatedBy;
}
