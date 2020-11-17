package com.app.infrastructure.controller;

import com.app.application.dto.CreateProductDto;
import com.app.application.dto.GetProductDto;
import com.app.application.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @PostMapping
    public Long createProduct(@RequestBody CreateProductDto createProductDto) {
        return productsService.createProduct(createProductDto);
    }

    @GetMapping
    public List<GetProductDto> getAllProducts() {
        return productsService.getAllProducts();
    }


    @GetMapping("/{id}")
    public GetProductDto getOneProduct(@PathVariable Long id){
        return productsService.getOneProduct(id);
    }
}
