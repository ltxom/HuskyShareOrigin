package com.huskyshare.backend.service;

import com.huskyshare.backend.dao.ProductDao;
import com.huskyshare.backend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
   @Autowired
   private ProductDao productDao;

   @Value("${huskyshare.resource.path}")
   private String resourcePath;

   @Value("${huskyshare.resource.runtime.dir}")
   private String runtimDir;

   public List<Product> getAllProduct() {
      return productDao.findAll();
   }

   public void saveProduct(Product product) {
      productDao.save(product);
   }

   public void saveItemImg(MultipartFile file, String name) {
      try {
         file.transferTo(new File(System.getProperty("user.dir")+"/"+runtimDir+"classes/static" +
                 "/img/items/" + name));
         file.transferTo(new File(resourcePath + "static/img/items/" + name));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
