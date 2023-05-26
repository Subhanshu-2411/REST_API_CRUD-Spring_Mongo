package com.example.usermanagement.service;

import com.example.usermanagement.collection.Image;
import com.example.usermanagement.repository.ImageRepository;
import lombok.SneakyThrows;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImplementation implements ImageService{

    @Autowired
    private ImageRepository imageRepository;

    @SneakyThrows
    @Override
    public String addImage(String originalFilename, MultipartFile image) {
        Image img = new Image();
        img.setTitle(originalFilename);
        img.setPhoto(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        return imageRepository.save(img).getId();
    }

    @Override
    public Image getImage(String id) {
        return imageRepository.findById(id).get();
    }
}
