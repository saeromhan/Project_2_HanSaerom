package com.example.project7.dto;

import com.example.project7.Entity.ProductEntity;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private Long minPriceWanted;

    public static ProductDto fromEntity(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setMinPriceWanted(entity.getMinPriceWanted());
        return dto;
    }
}


