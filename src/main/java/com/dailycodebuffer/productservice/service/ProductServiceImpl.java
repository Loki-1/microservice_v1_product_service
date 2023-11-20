package com.dailycodebuffer.productservice.service;

import com.dailycodebuffer.productservice.entity.Product;
import com.dailycodebuffer.productservice.exception.ProductServiceCustomException;
import com.dailycodebuffer.productservice.model.ProductRequest;
import com.dailycodebuffer.productservice.model.ProductResponse;
import com.dailycodebuffer.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product...");
        Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity()).price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product Created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Get the product for product id: {}", productId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product with given Id Not Found!", "PRODUCT_NOT_FOUND!"));

        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id: {}", quantity, productId);

        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

        if (product.getQuantity() < quantity) {
            throw new ProductServiceCustomException("Product does not have sufficient Quantity", "INSUFFICIENT_QUANTITY");
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity Updated Successfully");
    }
}
