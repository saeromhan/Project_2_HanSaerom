package com.example.project7.repository;

import com.example.project7.Entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> { Page<ProductEntity> findAll(Pageable pageable);
}