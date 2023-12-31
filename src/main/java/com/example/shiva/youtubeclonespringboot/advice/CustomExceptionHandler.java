package com.example.shiva.youtubeclonespringboot.advice;

import com.example.shiva.youtubeclonespringboot.exception.ApiError;
import com.example.shiva.youtubeclonespringboot.exception.CategoryNotFoundException;
import com.example.shiva.youtubeclonespringboot.exception.ChannelNotFoundException;
import com.example.shiva.youtubeclonespringboot.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handlerUserNotFoundException (UserNotFoundException e, WebRequest webRequest){
        return new ResponseEntity<ApiError>(new ApiError("User not found.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiError> handlerCategoryNotFoundException(CategoryNotFoundException e,WebRequest webRequest){
        return new ResponseEntity<>(new ApiError("Category not found.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ChannelNotFoundException.class)
    public ResponseEntity<ApiError> handlerChannelNotFoundException(CategoryNotFoundException e, WebRequest webRequest){
        return new ResponseEntity<>(new ApiError("Channel not found.", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

}
