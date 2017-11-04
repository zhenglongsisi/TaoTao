package com.taotao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Long on 2017/10/31
 * <p>
 * 图片上传
 * </p>
 */
@Controller
public class PictureController {

    private final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String picUpload(MultipartFile[] files, String uid, HttpServletRequest request) {
        logger.info(uid);
        for (MultipartFile file : files) {
            logger.info(file.getOriginalFilename() + "---" + file.getName());
//            file.transferTo(new File());
            String path = getClass().getResource("/").getPath();
            logger.info("picUpload : " + path);

            String servletPath = request.getServletPath();
            logger.info("picUpload : " + servletPath);

        }
        return "success";
    }


}
