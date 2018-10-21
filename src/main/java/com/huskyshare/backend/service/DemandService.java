package com.huskyshare.backend.service;

import com.huskyshare.backend.dao.DemandDao;
import com.huskyshare.backend.entity.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class DemandService {
   @Autowired
   private DemandDao demandDao;

   @Value("${huskyshare.resource.path}")
   private String resourcePath;

   @Value("${huskyshare.resource.runtime.dir}")
   private String runtimDir;

   public void saveDemand(Demand demand) {
      demandDao.save(demand);
   }

   public void saveItemImg(MultipartFile file, String name) {
      try {
         new File(System.getProperty("user.dir") + "/" + runtimDir +
                 "classes/static" +
                 "/img/demandItems/").mkdirs();
         File serverTempFile = new File(System.getProperty("user.dir") + "/" + runtimDir +
                 "classes/static" +
                 "/img/demandItems/" + name);
         file.transferTo(serverTempFile);

         new File(resourcePath + "static/img/demandItems/").mkdirs();
         File localFile = new File(resourcePath + "static/img/demandItems/" + name);

         Files.copy(serverTempFile.toPath(), localFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public List<Demand> getAllDemand() {
      return demandDao.findAll();
   }

}
