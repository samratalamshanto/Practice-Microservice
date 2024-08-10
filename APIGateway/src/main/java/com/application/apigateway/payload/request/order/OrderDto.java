package com.application.apigateway.payload.request.order;

import com.application.apigateway.enums.CommonStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private String productId;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String createdByUsername;
    private Long createdBy;
    @Enumerated(EnumType.STRING)
    private CommonStatus status;
}
