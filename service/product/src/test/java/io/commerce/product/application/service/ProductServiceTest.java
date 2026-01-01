package io.commerce.product.application.service;

import io.commerce.common.snowflake.Snowflake;
import io.commerce.product.application.dto.CreateProductCommand;
import io.commerce.product.domain.model.Product;
import io.commerce.product.domain.repository.ProductRepository;
import io.commerce.product.infra.entity.ProductEntity;
import io.commerce.product.support.error.ProductException;
import io.commerce.product.support.error.code.ProductErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Snowflake snowflake;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("상품 생성")
    void ProductCreateTest() {
        //given
        Long productId = 1L;
        CreateProductCommand command = CreateProductCommand.builder().name("test").price(10000L).build();

        given(productRepository.existsByName(command.getName())).willReturn(false);
        given(snowflake.nextId()).willReturn(productId);

        //when
        Long resultId = productService.createProduct(command);

        //then
        assertThat(resultId).isEqualTo(productId);
        verify(productRepository).save(any(Product.class));
    }

    @Test
    @DisplayName("이미 존재하는 상품 저장시 예외")
    void ProductCreateFailTest() {
        //given
        CreateProductCommand command = CreateProductCommand.builder().name("test").price(10000L).build();

        given(productRepository.existsByName(command.getName())).willReturn(true);

        // when / then
        assertThatThrownBy(() -> productService.createProduct(command))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining(ProductErrorCode.PRODUCT_ALREADY_EXISTS.getMessage());

        verify(productRepository, never()).save(any());
    }

    @Test
    @DisplayName("ID 로 상품조회")
    void findByProductIdTest() {
        //given
        Long productId = 1L;
        Product product = Product.create(productId, "test", 10000L);

        given(productRepository.findById(productId)).willReturn(Optional.of(product));

        //when
        Product result = productService.getProduct(productId);

        //then
        assertThat(result).isEqualTo(product);
    }

    @Test
    @DisplayName("상품명 상품조회")
    void findByProductNameTest() {
        //given
        Long productId = 1L;
        Product product = Product.create(productId, "test", 10000L);

        given(productRepository.findByName("test")).willReturn(Optional.of(product));

        //when
        Product result = productService.getProduct("test");

        //then
        assertThat(result).isEqualTo(product);
    }

    @Test
    @DisplayName("상품명 상품조회시 없으면 예외")
    void findByProductNameFailTest() {
        //given
        Long productId = 1L;
        Product product = Product.create(productId, "test", 10000L);

        given(productRepository.findByName("test")).willReturn(Optional.empty());

        //when / then
        assertThatThrownBy(() -> productService.getProduct("test"))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining(ProductErrorCode.PRODUCT_NOT_FOUND.getMessage());

    }
}