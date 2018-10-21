package com.huskyshare.backend.web;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huskyshare.backend.service.StorageService;

@Controller
public class FileUploadController {
   @Autowired
   private StorageService storageService;

   @GetMapping("/upload")
   public String listUploadedFiles() {
      return "uploadForm";
   }



   @PostMapping("/upload")
   public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                  RedirectAttributes redirectAttributes) {
      storageService.store(file);
      redirectAttributes.addFlashAttribute("message",
              "You successfully uploaded " + file.getOriginalFilename() + "!");

      return "uploadForm";
   }

//   @ExceptionHandler(StorageFileNotFoundException.class)
//   public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//      return ResponseEntity.notFound().build();
//   }

}