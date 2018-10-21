package com.huskyshare.backend.service;

import com.huskyshare.backend.dao.CategoryDao;
import com.huskyshare.backend.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorySerive {
   @Autowired
   private CategoryDao categoryDao;

   public List<Category> getCategoryList() {
      return categoryDao.findAll();
   }

}
