package com.huskyshare.backend;

import com.huskyshare.backend.entity.Category;
import com.huskyshare.backend.entity.Product;
import com.huskyshare.backend.entity.User;
import com.huskyshare.backend.service.CategorySerive;
import com.huskyshare.backend.service.ProductService;
import com.huskyshare.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan("com.huskyshare.backend")
public class BackendApplicationTests {
   @Autowired
   private ProductService productService;

   @Autowired
   private UserService userService;

   @Autowired
   private CategorySerive categoryService;

   @Test
   public void contextLoads() {
      Product product = new Product();
      product.setCategory(categoryService.getCategoryList().get(1));

      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      product.setCreateTime(timestamp);
      product.setDescription("爽过吸大麻");
      product.setMarketPrice(998.0);
      product.setProductName("维他柠檬茶");
      product.setQuantity(100);

      User user = userService.findUserByEmail("ltxom@uw.edu");
      product.setSeller(user);
      product.setSellPrice(9.98);
      productService.saveProduct(product);
   }

}
