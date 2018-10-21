package com.huskyshare.backend.web;

import com.huskyshare.backend.entity.Category;
import com.huskyshare.backend.entity.Demand;
import com.huskyshare.backend.entity.Product;
import com.huskyshare.backend.entity.User;
import com.huskyshare.backend.service.CategorySerive;
import com.huskyshare.backend.service.DemandService;
import com.huskyshare.backend.service.LoginTokenService;
import com.huskyshare.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
   @Autowired
   private CategorySerive categorySerive;

   @Autowired
   private ProductService productService;

   @Autowired
   private LoginTokenService loginTokenService;

   @Autowired
   private DemandService demandService;

   @RequestMapping(value = "/items")
   private ModelAndView itemsForm(@RequestParam(value = "categoryID", required = false) String categoryID
           , Model model) {
      ModelAndView modelAndView = new ModelAndView("itemsBuy");
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
                  if (product.getCategory().equals(categoryObj.getCategory())) {
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


   @RequestMapping(value = "/lend", method = RequestMethod.GET)
   public ModelAndView lendForm(HttpServletRequest request, Model model) {
      ModelAndView modelAndView = new ModelAndView("lend");
      User user = handleLoginState(request, model);

      if (user == null) {
         modelAndView.setViewName("login");
         return modelAndView;
      }

      modelAndView.addObject("categories", categorySerive.getCategoryList());
      return modelAndView;
   }


   @RequestMapping(value = "/lend", method = RequestMethod.POST)
   public ModelAndView lendPost(@RequestParam("file") MultipartFile file, @ModelAttribute(
           "product") Product product,
                                HttpServletRequest request, Model model) {
      User user = handleLoginState(request, model);

      if (user == null) {
         ModelAndView modelAndView = new ModelAndView("login");
         return modelAndView;
      }
      product.setSeller(user);
      product.setCreateTime(new Timestamp(System.currentTimeMillis()));
      String fileName =
              user.getUsername() + System.currentTimeMillis() + ".jpg";
      productService.saveItemImg(file, fileName);

      product.setImgPath(fileName);
      productService.saveProduct(product);
      return this.itemsForm("1", model);
   }

   @RequestMapping(value = "/reserve")
   private ModelAndView reserveForm(@RequestParam(value = "id", required = false) String productId
           , Model model) {
      ModelAndView modelAndView = new ModelAndView("itemsBuy");
      try {
         List<Product> productList =
                 productService.getAllProduct();
         Product targetProduct = null;
         for (Product product : productList) {
            if (product.getId().equals(Integer.parseInt(productId))) {
               targetProduct = product;
               break;
            }
         }
         if (targetProduct != null) {
            model.addAttribute("product", targetProduct);
            modelAndView.setViewName("reserve");
            return modelAndView;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return modelAndView;
   }

   @RequestMapping(value = "/demand")
   private ModelAndView demandForm(
           HttpServletRequest request, Model model) {
      ModelAndView modelAndView = new ModelAndView("demand");
      User user = handleLoginState(request, model);

      if (user == null) {
         modelAndView.setViewName("login");
         return modelAndView;
      }

      modelAndView.addObject("categories", categorySerive.getCategoryList());
      return modelAndView;

   }

   @RequestMapping(value = "/demand", method = RequestMethod.POST)
   public ModelAndView demandPost(@RequestParam("file") MultipartFile file, @ModelAttribute(
           "demand") Demand demand,
                                  HttpServletRequest request, Model model) {
      User user = handleLoginState(request, model);

      if (user == null) {
         ModelAndView modelAndView = new ModelAndView("login");
         return modelAndView;
      }
      demand.setSeller(user);
      demand.setCreateTime(new Timestamp(System.currentTimeMillis()));
      String fileName =
              user.getUsername() + System.currentTimeMillis() + ".jpg";
      demandService.saveItemImg(file, fileName);

      demand.setImgPath(fileName);
      demandService.saveDemand(demand);
      return this.itemsForm("1", model);
   }

   @RequestMapping(value = "/offers")
   private ModelAndView offersForm(@RequestParam(value = "categoryID", required = false) String categoryID
           , Model model) {
      ModelAndView modelAndView = new ModelAndView("itemsSell");
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
               List<Demand> list = new ArrayList<Demand>();
               for (Demand demand : demandService.getAllDemand()) {
                  System.out.println(demand.getDemandName());
                  if (demand.getCategory().equals(categoryObj.getCategory())) {
                     list.add(demand);
                  }
               }
               modelAndView.addObject("demandList", list);

               modelAndView.addObject("categorys", categoryList);
               return modelAndView;
            }
         } catch (Exception e) {

         }
      }

      model.addAttribute("categoryID", 1);
      modelAndView.addObject("demandList", demandService.getAllDemand());

      modelAndView.addObject("categorys", categoryList);
      return modelAndView;
   }

   @RequestMapping(value = "/search", method = RequestMethod.POST)
   public ModelAndView searchPost(@RequestParam(value = "keyword", required = true) String keyword
           , Model model) {
      ModelAndView modelAndView = new ModelAndView("itemsBuy");
      List<Product> productList = productService.getAllProduct();
      List<Product> resultList = new ArrayList<>();
      for (Product product : productList) {
         if (product.getProductName().toLowerCase().contains(keyword.toLowerCase()) || product.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
            resultList.add(product);
         }
      }
      model.addAttribute("productList", resultList);
      return modelAndView;
   }

   private User handleLoginState(HttpServletRequest request, Model model) {
      User user = loginTokenService.searchToken(request.getSession().getAttribute("token"));
      if (user != null) {
         model.addAttribute("username", user.getUsername());
      }
      return user;
   }
}
