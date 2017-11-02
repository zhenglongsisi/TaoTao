package com.taotao.service.impl;

import com.taotao.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Long on 2017/11/1
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Value("${IMAGE_SERVER_URL}")
    private String basePicUrl;

    @Override
    public String save(MultipartFile file, String path) throws IOException {
        String filename = file.getOriginalFilename();
        String ext = filename.substring(filename.lastIndexOf("."));
        File dest = new File(path, randomFileName() + ext);
        file.transferTo(dest);
        return basePicUrl + dest.getName();
    }

    private String randomFileName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
