package com.huskyshare.backend.dao;

import com.huskyshare.backend.entity.Category;
import com.huskyshare.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
}

