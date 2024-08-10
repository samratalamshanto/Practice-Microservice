package com.application.apigateway.controller.order;

import com.application.apigateway.payload.request.order.OrderDto;
import com.application.apigateway.payload.response.CommonResponse;
import com.application.apigateway.service.order.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create-order")
    public ResponseEntity<CommonResponse> createOrder(@RequestBody OrderDto order, HttpServletRequest request) {
        return orderService.createOrder(order, request);
    }


    @GetMapping("/create-order-get")
    public String createOrderGet(HttpServletRequest request) {
        return "orderService.createOrder(order, request)";
    }
}
