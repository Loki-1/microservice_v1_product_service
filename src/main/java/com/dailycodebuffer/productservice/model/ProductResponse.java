package com.dailycodebuffer.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductResponse {
    private String productName;
    private long productId;
    private long quantity;
    private long price;
}
