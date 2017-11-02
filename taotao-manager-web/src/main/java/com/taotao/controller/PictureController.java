package com.taotao.controller;

import com.google.common.collect.Maps;
import com.taotao.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Long on 2017/11/1
 */
@Controller
public class PictureController {

    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Resource
    private StorageService storageService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map picUpload(@RequestParam("uploadFile") MultipartFile pic, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("/") + "upload/";
        logger.info("picUpload:" + path);
        HashMap<String, Object> hashMap = Maps.newHashMap();
        try {
            String picUrl = storageService.save(pic, path);
            logger.info("picUpload:" + picUrl);
            hashMap.put("error", 0);
            hashMap.put("url", picUrl);
        } catch (IOException e) {
            e.printStackTrace();
            hashMap.put("error", 1);
            hashMap.put("message", "图片上传失败");
        }
        return hashMap;
    }
}
