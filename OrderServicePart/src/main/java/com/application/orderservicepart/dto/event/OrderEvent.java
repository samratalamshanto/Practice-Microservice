package com.application.orderservicepart.dto.event;

import com.application.orderservicepart.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private OrderDetails order;
    private String eventDetails;
}
