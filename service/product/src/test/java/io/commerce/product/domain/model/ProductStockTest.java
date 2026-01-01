package io.commerce.product.domain.model;

import io.commerce.product.support.error.ProductStockException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ProductStockTest {

    @Test
    void productCreateTest() {
        //given
        long id = 1L;
        long quantity = 100L;

        //when
        ProductStock productStock = ProductStock.create(1L, 100L);

        //then
        assertThat(productStock.getProductId()).isEqualTo(id);
        assertThat(productStock.getQuantity()).isEqualTo(quantity);
    }

    @Test
    @DisplayName("상품 증가")
    void productStockIncreaseTest() {
        //given
        ProductStock stock = ProductStock.create(1L, 100L);

        //when
        stock.increaseQuantity(50L);

        //then
        assertThat(stock.getQuantity()).isEqualTo(150L);
    }

    @Test
    @DisplayName("상품 증가시 0 이거나 NUll 경우")
    void productStockIncreaseFailTest() {
        //given
        ProductStock stock01 = ProductStock.create(1L, 100L);
        ProductStock stock02 = ProductStock.create(1L, 100L);

        //when||then
        assertThatThrownBy(() -> stock01.increaseQuantity(0L))
                .isInstanceOf(ProductStockException.class);
        assertThatThrownBy(() -> stock01.increaseQuantity(null))
                .isInstanceOf(ProductStockException.class);
    }

    @Test
    @DisplayName("상품 감소")
    void productStockDecreaseTest() {
        //given
        ProductStock stock = ProductStock.create(1L, 100L);

        //when
        stock.decreaseQuantity(50L);

        //then
        assertThat(stock.getQuantity()).isEqualTo(50L);
    }

    @Test
    @DisplayName("상품 감소시 현재 재고보다 작거나, 0 또는 NUll 경우")
    void productStockDecreaseFailTest() {
        //given
        ProductStock stock01 = ProductStock.create(1L, 100L);
        ProductStock stock02 = ProductStock.create(1L, 100L);

        //when||then
        assertThatThrownBy(() -> stock01.decreaseQuantity(110L))
                .isInstanceOf(ProductStockException.class);
        assertThatThrownBy(() -> stock01.decreaseQuantity(0L))
                .isInstanceOf(ProductStockException.class);
        assertThatThrownBy(() -> stock01.decreaseQuantity(null))
                .isInstanceOf(ProductStockException.class);
    }

}