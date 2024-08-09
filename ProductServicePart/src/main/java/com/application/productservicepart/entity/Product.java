package com.application.productservicepart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private LocalDateTime createdDT;
    private LocalDateTime updatedDT;
    private LocalDateTime deletedDT;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;
}
