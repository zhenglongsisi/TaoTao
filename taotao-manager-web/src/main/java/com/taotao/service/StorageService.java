package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Long on 2017/11/1
 */
public interface StorageService {

    String save(MultipartFile file, String path) throws IOException;

}
