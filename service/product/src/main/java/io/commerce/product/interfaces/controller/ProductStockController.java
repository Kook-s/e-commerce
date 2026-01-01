package io.commerce.product.interfaces.controller;

import io.commerce.product.application.service.ProductStockService;
import io.commerce.product.interfaces.dto.StockQuantityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product-stock")
public class ProductStockController {
    private final ProductStockService productStockService;

    @PutMapping("/increase")
    public ResponseEntity<Void> increase(@RequestBody StockQuantityRequest request) {
        productStockService.increaseStock(request.getId(), request.getQuantity());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/decrease")
    public ResponseEntity<Void> decrease(@RequestBody StockQuantityRequest request) {
        productStockService.decreaseStock(request.getId(), request.getQuantity());
        return ResponseEntity.noContent().build();
    }
}
