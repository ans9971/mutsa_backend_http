package com.example.http;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.plaf.PanelUI;

@Slf4j
@Controller
public class MappingController {
    private final Logger logger = LoggerFactory.getLogger(MappingController.class);

    //"/path"로 오는 요청에 대해서 GET 메소드를 실행하고 싶을때
    @RequestMapping(
            // 여기에 작성하는 내용은?
            value = "/path"
            , method = RequestMethod.GET
    )
    public String getPath() {
        log.info("GET /path");
        return "index";
    }

    @RequestMapping(
            // 여기에 작성하는 내용은?
            value = "/path"
            , method = RequestMethod.POST
    )
    public String postPath() {
        log.info("Post /path");
        return "index";
    }


    @RequestMapping(
            value = "/path",
            method = {RequestMethod.PUT, RequestMethod.DELETE}

    )
    public String putOrDeletePath() {

        log.info("PUT or DELETE /path");
        return "index";
    }

    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE

    )
    public String consumes() {
        log.info("POST /path Content-Type : application/json");
        return "index";
    }

    // '/path'로 오는 post 요청이면서
    //헤더에 x-likelion이라는 헤더가 값이 hello 로 저장되있을때
    //method를 실행하고 싶을때
    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST,
            headers = "x-likelion=hello"

    )
    public String headerWith() {
        log.info("POST /path wite");
        return "index";
    }

    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST,
            params = "likelion=hello"

    )
    public String paramWith() {
        log.info("POST /path param hello");
        return "index";
    }


}
