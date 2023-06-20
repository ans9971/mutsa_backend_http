package com.example.http;

import com.example.http.dto.ArticleDto;
import com.example.http.dto.ResponseDto;
import com.example.http.dto.WriterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
//@RestController
public class BodyController {
    // '/body'라는 요청이 들어왔을때,
    //responseDto 데이터를 표현한 json 응답을 반환하는 메소드
    @PostMapping("/body")
    //response 응답의 body임을 나타내는 어노테이션
    public @ResponseBody ResponseDto body(
            @RequestBody ArticleDto requestDto
    ) {
        log.info(requestDto.toString());
        ResponseDto response = new ResponseDto();
        response.setStatus(200);
        response.setMessage("success 입니당");
        return response;
    }

    // '/body'로 ArticleDto를 표현한 json과함께
    // 요청이 들어왔을때, responseDto를 표현한 json을 포함해 응답하는 메소드
//    @PostMapping("/body")
//    public void rebody(
//            @RequestBody ArticleDto dto
//    ) {
//        log.info("POST /body" +dto.toString());
//
//    }

    @PostMapping("/body-2")
    @ResponseBody
    public ResponseDto body2(
            @RequestBody
            WriterDto dto
    ) {
        log.info(dto.toString());
        ResponseDto response = new ResponseDto();
        response.setStatus(200);
        response.setMessage("success 입니당");
        return response;
    }
    @PostMapping("/body-3")
    @ResponseBody
    public ResponseDto body3(
            @RequestBody
            ArticleDto dto
    ) {
        log.info(dto.toString());
        ResponseDto response = new ResponseDto();
        response.setStatus(200);
        response.setMessage("success 입니당");
        return response;
    }

    @PostMapping("/body-4")
    @ResponseBody
    public ResponseDto body4(
            @RequestBody
            ArticleDto dto

    ) {
        log.info(dto.toString());
//        ResponseDto response = new ResponseDto();
//        response.setStatus(200);
//        response.setMessage("success 입니당");
        return new ResponseDto();
    }

    //@ResponseBody는 요청의 http body만 설정
    // header를 추가하거나 status code를 고르고 싶을때
    //ResponsseEntity<T>
//    @PostMapping("/entity")
//    public ResponseEntity<ResponseDto> entity(
//            @RequestBody
//            ArticleDto dto
//
//    ) {
//        log.info(dto.toString());
//        ResponseDto response = new ResponseDto();
//        response.setStatus(200);
//        response.setMessage("success 입니당");
//        //1.  새 ResponseEntity 객체 생성, 객체 그냥 쓰기
//        ResponseEntity<ResponseDto> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
////        return responseEntity;
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("x-likelion-custom", "hello");
////        return new ResponseEntity<>(
////                response,headers,HttpStatus.ACCEPTED
////        );
//        return ResponseEntity
//                .internalServerError()
//                .header("x-likelion-5", "12")
//
//    }
}
