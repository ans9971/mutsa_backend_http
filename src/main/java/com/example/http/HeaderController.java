package com.example.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Slf4j
@Controller
public class HeaderController {
    // 'header-one'으로 들어온 http 요청에 대하여
    // header 중 'x-likelion' 이라는 헤더의 값을 인자로 전달받고 싶을 때
    @PostMapping("/header-one")
    public String getHeader(@RequestHeader("x-likelion") String header
    ) {
        log.info("POST /header-one" + header);
        return "index";
    }

    ///header-optional으로 들어온 http 요청에 대하여
    //해더 중 x-likelion이 있으면 할당 없으면 null로 받고싶을때
//    @PostMapping("/header-optional")
//    public String getHeaderOptional(@RequestHeader("x-likelion", required = false) String header
//    ) {
//        log.info("POST /header-optional header" + header);
//
//
//        return "index";
//    }

    ///header-type으로 들어온 http 요청에 대하여
    //해더 중 x-likelion-in이 있으면 integer에 할당
    @PostMapping("/header-type")
    public String getHeaderOptional(@RequestHeader("x-likelion-int") Integer header
    ) {
        log.info("POST /header-optional int header" + header);


        return "index";
    }

    //'header-all'로 들어온 http 요청의
    //모든 헤더를 확인하고 싶을때
    @PostMapping("/header-all")
    public String getHeaderAll(
            @RequestHeader Map<String , String> headerMap
    ) {
//        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
//            log.info(String.format(
//                    "%s : %s", entry.getKey(), entry.getValue()
//            ));
//
//        }
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            log.info(String.format(
                    "%s : %s", entry.getKey(), entry.getValue()
            ));

        }

        return "index";
    }

}
