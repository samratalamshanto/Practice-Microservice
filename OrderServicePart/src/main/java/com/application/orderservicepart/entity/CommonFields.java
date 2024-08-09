package com.application.orderservicepart.entity;

import com.application.orderservicepart.enums.CommonStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private CommonStatus status;
}
