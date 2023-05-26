package com.example.usermanagement.controller;

import com.example.usermanagement.collection.Image;
import com.example.usermanagement.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/photo")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping
    public String addImage(@RequestParam("image")MultipartFile image) {
        return imageService.addImage(image.getOriginalFilename(),image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadImage(@PathVariable String id) {

        Image image = imageService.getImage(id);

        Resource resource = new ByteArrayResource(image.getPhoto().getData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" " + image.getTitle() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
