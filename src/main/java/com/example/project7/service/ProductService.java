package com.example.project7.service;

import com.example.project7.dto.ProductDto;
import com.example.project7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import com.example.project7.Entity.ProductEntity;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void updateProduct(Long itemId, ProductDto productDto) {
    }

    public void uploadImage(Long itemId, MultipartFile imageFile, String writer, String password) {
    }

    public void deleteProduct(Long itemId, String writer, String password) {
    }

    public void createProduct(ProductDto productDto) {
    }

    public Page<ProductDto> getProducts(Pageable pageable) {
        Page<ProductEntity> products = repository.findAll(pageable);

        // 가져온 상품 정보를 Dto로 변환
        Page<ProductDto> productDtos = products.map(ProductDto::fromEntity);

        // 변환된 Dto 리스트를 반환
        return productDtos;
    }

    public Object getProduct(Long itemId) {ProductEntity entity = repository.findById(itemId)
            .orElseThrow(() -> new ProductNotFoundException("해당 상품을 찾을 수 없습니다."));

        return ProductDto.fromEntity(entity);
    }

    // 비즈니스 로직 추가
    // ex.제품 생성,수정, 제품 조회, 제품 삭제 등의 메서드 구현
}
