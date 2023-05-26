package com.example.usermanagement.service;

import com.example.usermanagement.collection.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String addImage(String originalFilename, MultipartFile image);

    Image getImage(String id);
}
