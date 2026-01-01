package io.commerce.product.interfaces.controller;

import io.commerce.product.application.facade.ProductFacade;
import io.commerce.product.application.service.ProductService;
import io.commerce.product.infra.repository.query.ProductWithStockRead;
import io.commerce.product.interfaces.dto.CreateProductRequest;
import io.commerce.product.interfaces.dto.ProductDetailResponse;
import io.commerce.product.interfaces.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductFacade productFacade;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ProductResponse.from(productService.getProduct(id)));
    }

    @GetMapping("/detail/{name}")
    public ResponseEntity<ProductDetailResponse> getProduct(@PathVariable("name") String name) {
        return ResponseEntity.ok(ProductDetailResponse.from(productFacade.getProductDetail(name)));
    }

    @GetMapping("/detail/list")
    public ResponseEntity<List<ProductWithStockRead>> getProductList() {
        return ResponseEntity.ok(productFacade.getProductList());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        List<ProductResponse> responses = productService.getProducts().stream()
                .map(ProductResponse::from)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @PostMapping("/create/product")
    public ResponseEntity<Void> createProduct(@RequestBody CreateProductRequest request) {
        productFacade.createProduct(request.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/product/{productId}")
    public ResponseEntity<Void> createProduct(@PathVariable("productId") Long productId) {
        productFacade.deleteProduct(productId);
        return ResponseEntity.noContent().build();

    }
}
