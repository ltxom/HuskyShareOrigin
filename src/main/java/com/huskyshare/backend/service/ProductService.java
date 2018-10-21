package com.huskyshare.backend.service;

import com.huskyshare.backend.dao.ProductDao;
import com.huskyshare.backend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
   @Autowired
   private ProductDao productDao;

   public List<Product> getAllProduct(){
      return productDao.findAll();
   }
}
