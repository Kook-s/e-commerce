package io.commerce.product.application.service;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.product.domain.model.ProductStock;
import io.commerce.product.domain.repository.ProductStockRepository;
import io.commerce.product.support.error.ProductStockException;
import io.commerce.product.support.error.code.ProductStockErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductStockServiceTest {

    @Mock
    private ProductStockRepository productStockRepository;

    @Mock
    private Snowflake snowflake;

    @InjectMocks
    private ProductStockService productStockService;

    @Test
    @DisplayName("상품 재고 생성")
    void stockCreateTest() {
        //given
        Long productId = 1L;

        //when
        productStockService.createStock(productId);

        //then
        verify(productStockRepository).save(any(ProductStock.class));
    }

    @Test
    @DisplayName("상품 재고 조회")
    void stockFindTest() {
        //given
        Long productId = 1L;
        ProductStock stock = ProductStock.create(productId, 100L);
        given(productStockRepository
                .findById(productId))
                .willReturn(Optional.of(stock));

        //when
        ProductStock productStock = productStockService.getProductStock(productId);

        //then
        assertThat(productStock).isEqualTo(stock);
    }

    @Test
    @DisplayName("상품 재고 조회시 예외")
    void stockFindFailTest() {
        //given
        Long productId = 1L;
        given(productStockRepository
                .findById(productId))
                .willReturn(Optional.empty());

        //when / then
        assertThatThrownBy(() -> productStockService.getProductStock(productId))
                .isInstanceOf(ProductStockException.class)
                .hasMessageContaining(ProductStockErrorCode.PRODUCT_STOCK_NOT_FOUND.getMessage());

    }

    @Test
    @DisplayName("상품 재고 증가")
    void stockIncreaseTest() {
        // given
        ProductStock stock = ProductStock.create(1L, 10L);
        given(productStockRepository.findById(1L))
                .willReturn(Optional.of(stock));

        // when
        productStockService.increaseStock(1L, 5L);

        // then
        assertThat(stock.getQuantity()).isEqualTo(15L);
        verify(productStockRepository)
                .increaseStock(1L, 5L);
    }

    @Test
    @DisplayName("상품 재고 감소")
    void stockDecreaseTest() {
        // given
        ProductStock stock = ProductStock.create(1L, 10L);
        given(productStockRepository.findById(1L))
                .willReturn(Optional.of(stock));

        // when
        productStockService.decreaseStock(1L, 5L);

        // then
        assertThat(stock.getQuantity()).isEqualTo(5L);
        verify(productStockRepository)
                .increaseStock(1L, 5L);
    }
}