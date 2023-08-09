package com.example.project7.controller;

import com.example.project7.dto.ProductDto;
import com.example.project7.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/items")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
        return ResponseEntity.ok("등록이 완료되었습니다.");
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getProducts(Pageable pageable) {
        return ResponseEntity.ok(productService.getProducts(pageable));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long itemId) {
        return ResponseEntity.ok(productService.getProduct(itemId));
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<String> updateProduct(@PathVariable Long itemId, @RequestBody ProductDto productDto) {
        productService.updateProduct(itemId, productDto);
        return ResponseEntity.ok("물품이 수정되었습니다.");
    }

    @PutMapping("/{itemId}/image")
    public ResponseEntity<String> uploadImage(@PathVariable Long itemId, @RequestParam("image") MultipartFile imageFile,
                                              @RequestParam String writer, @RequestParam String password) throws IOException {
        productService.uploadImage(itemId, imageFile, writer, password);
        return ResponseEntity.ok("이미지가 등록되었습니다.");
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long itemId, @RequestParam String writer, @RequestParam String password) {
        productService.deleteProduct(itemId, writer, password);
        return ResponseEntity.ok("물품을 삭제했습니다.ekek"); fef
    }
}
