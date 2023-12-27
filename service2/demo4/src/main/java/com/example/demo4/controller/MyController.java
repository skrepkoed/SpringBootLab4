package com.example.demo4.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.exception.ValidationFailedException;
import com.example.demo4.model.Codes;
import com.example.demo4.model.ErrorCodes;
import com.example.demo4.model.ErrorMessages;
import com.example.demo4.model.Request;
import com.example.demo4.model.Response;
import com.example.demo4.service.ModifyResponseService;
import com.example.demo4.service.ResponseTimeDiff;
import com.example.demo4.service.ValidationService;
import com.example.demo4.util.DateTimeUtil;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;

    public MyController(ValidationService validationService,
    @Qualifier("ModifyOperationUidResponseService")
    ModifyResponseService modifyResponseService    
    ){
        this.validationService=validationService;
        this.modifyResponseService=modifyResponseService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult ){
        log.info("request: {}",request);
        Response response =  Response.builder()
        .uid(request.getUid())
        .operationUid(request.getOperationUid())
        .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
        .code(Codes.SUCCESS)
        .errorCode(ErrorCodes.EMPTY)
        .errorMessage(ErrorMessages.EMPTY)
        .build();
        log.info("response:{}", response);
        log.info("Time Diff: {}", ResponseTimeDiff.diff(request.getSystemTime()));
        
        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("response:{}", response);
            return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("response:{}", response);
            return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        modifyResponseService.modify(response);
        log.info("response:{}", response);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
