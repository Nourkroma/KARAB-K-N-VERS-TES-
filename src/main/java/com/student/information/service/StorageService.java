package com.student.information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.student.information.dto.ImageData;
import com.student.information.dto.Student;
import com.student.information.repo.Student_Repo;
import com.student.information.util.ImageUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private Student_Repo repository;

    public ImageData uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = (ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());

        return imageData;
    }

    public byte[] downloadImage(ImageData fileName) {
        byte[] images = ImageUtils.decompressImage(fileName.getImageData());
        return images;
    }
}
