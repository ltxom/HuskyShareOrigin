package com.huskyshare.backend.service;

import com.huskyshare.backend.dao.ProductDao;
import com.huskyshare.backend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
         new File(System.getProperty("user.dir") + "/" + runtimDir +
                 "classes/static" +
                 "/img/productItems/").mkdirs();
         File serverTempFile = new File(System.getProperty("user.dir") + "/" + runtimDir +
                 "classes/static" +
                 "/img/productItems/" + name);
         file.transferTo(serverTempFile);

         new File(resourcePath + "static/img/productItems/").mkdirs();
         File localFile = new File(resourcePath + "static/img/productItems/" + name);

         Files.copy(serverTempFile.toPath(), localFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

}
