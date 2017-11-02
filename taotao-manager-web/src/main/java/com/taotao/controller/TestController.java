package com.taotao.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Long on 2017/11/2
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/json")
    public JsonEntity jsonRequest(@RequestBody() JsonEntity data) {
        return data;
    }


    public static class JsonEntity {
        private Integer id;
        private String title;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "JsonEntity{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }
    }


}
