package com.application.orderservicepart.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class CommonFields {
    @CreationTimestamp
    private LocalDateTime createdDT;
    private String createdByUsername;
    private Long createdBy;
}
