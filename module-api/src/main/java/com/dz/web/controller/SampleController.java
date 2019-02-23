package com.dz.web.controller;

import com.dz.constant.ResponseSuccess;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dz.constant.ResponseCode.ILLEGAL_ARGS_FAIL;
import static com.dz.exceptions.CustomLogicExcepion.internalException;


@Slf4j
@RestController
@NoArgsConstructor
@RequestMapping("/sample")
public class SampleController {


    @GetMapping("/success")
    public ResponseEntity getSuccess(){

        return ResponseSuccess.success();
    }



    @GetMapping("/fail")
    public ResponseEntity getFail(){
        throw internalException(ILLEGAL_ARGS_FAIL);

    }

    @GetMapping("/git/pull/request")
    public ResponseEntity gitPullRequestTest(){

        //수정했어요
        throw internalException(ILLEGAL_ARGS_FAIL);

    }



}
