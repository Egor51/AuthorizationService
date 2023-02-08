package com.app.authorizationservice.exeotion;

import com.app.authorizationservice.exeotion.exeptions.InvalidCredentials;
import com.app.authorizationservice.exeotion.exeptions.UnauthorizedUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<AppError> catchUnauthorizedUser(UnauthorizedUser e){
        log.info("Exception: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),e.getMessage()),HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler
    public ResponseEntity<AppError> catchInvalidCredentials(InvalidCredentials e){
        return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}