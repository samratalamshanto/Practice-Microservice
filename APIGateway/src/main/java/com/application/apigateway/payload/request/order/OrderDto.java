package com.application.apigateway.payload.request.order;

import com.application.apigateway.enums.CommonStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String productId;
    private String productName;
    private double productPrice;
    private String productDescription;
//    @CreationTimestamp
//    private Timestamp createdDT;
    private String createdByUsername;
    private Long createdBy;
    @Enumerated(EnumType.STRING)
    private CommonStatus status;
}
