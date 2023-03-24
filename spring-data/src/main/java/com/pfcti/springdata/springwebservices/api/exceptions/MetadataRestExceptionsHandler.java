package com.pfcti.springdata.springwebservices.api.exceptions;

import com.pfcti.springdata.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//@ControllerAdvice(basePackages = "com.demo.springwebservices.api")
@ControllerAdvice(basePackages = "com.pfcti.springdata.springwebservices.api")

@Slf4j
public class MetadataRestExceptionsHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        return handleExceptionHandler(e);
    }

    public ResponseEntity<ErrorDto> handleExceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        int codigo = 0;
        String message = e.getMessage();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorDto(httpStatus.value(), codigo, message), httpStatus);
    }
}
