package com.huskyshare.backend.web;

import com.huskyshare.backend.entity.Category;
import com.huskyshare.backend.entity.Product;
import com.huskyshare.backend.service.CategorySerive;
import com.huskyshare.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
   @Autowired
   private CategorySerive categorySerive;

   @Autowired
   private ProductService productService;

   @RequestMapping(value = "/items", method = RequestMethod.GET)
   private ModelAndView itemsForm(@RequestParam(value = "categoryID", required = false) String categoryID
           , Model model) {
      ModelAndView modelAndView = new ModelAndView("items");
      List<Category> categoryList = categorySerive.getCategoryList();


      if (categoryID != null && !categoryID.equals("1")) {
         int categoryIntID = -1;
         try {
            categoryIntID = Integer.parseInt(categoryID);
            model.addAttribute("categoryID", categoryID);

            Category categoryObj = null;
            for (Category category : categoryList) {
               if (category.getId().equals(categoryIntID)) {
                  categoryObj = category;
                  break;
               }
            }
            if (categoryObj != null) {
               List<Product> list = new ArrayList<Product>();
               for (Product product : productService.getAllProduct()) {
                  if (product.getCategory().equals(categoryObj)) {
                     list.add(product);
                  }
               }
               modelAndView.addObject("productList", list);

               modelAndView.addObject("categorys", categoryList);
               return modelAndView;
            }
         } catch (Exception e) {

         }
      }

      model.addAttribute("categoryID", 1);
      modelAndView.addObject("productList", productService.getAllProduct());

      modelAndView.addObject("categorys", categoryList);
      return modelAndView;
   }
}
