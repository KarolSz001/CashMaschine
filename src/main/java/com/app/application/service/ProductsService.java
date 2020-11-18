package com.app.application.service;

import com.app.application.dto.CreateProductDto;
import com.app.application.dto.GetProductDto;
import com.app.application.exception.ProductsServiceException;
import com.app.application.mapper.Mappers;
import com.app.application.validator.CreateProductDtoValidator;
import com.app.domain.product.Product;
import com.app.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductsService {

    private final ProductRepository productRepository;

    public Long createProduct(CreateProductDto createProductDto) {
        var createProductDtoValidator = new CreateProductDtoValidator();
        var errors = createProductDtoValidator.validate(createProductDto);
        if (!errors.isEmpty()) {
            var errorMessage = errors
                    .entrySet()
                    .stream()
                    .map(e -> e.getKey() + ": " + e.getValue())
                    .collect(Collectors.joining(", "));
            throw new ProductsServiceException(errorMessage);
        }

        var product = Mappers.fromCreateProductDtoToGetProductDto(createProductDto);
        return productRepository
                .save(product)
                .map(Product::getId)
                .orElseThrow(() -> new ProductsServiceException("Cannot insert product to db"));
    }

    public List<GetProductDto> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(Mappers::fromProductToGetProductDto)
                .collect(Collectors.toList());
    }

    public GetProductDto getOneProduct(Long id) {
        if (id == null) {
            throw new IllegalStateException("null arg");
        }
        return productRepository.findById(id)
                .map(Mappers::fromProductToGetProductDto)
                .orElseThrow(() -> new ProductsServiceException("NO FOUND PRODUCT"));
    }
}
