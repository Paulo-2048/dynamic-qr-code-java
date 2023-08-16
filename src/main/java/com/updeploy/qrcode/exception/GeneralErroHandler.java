package com.updeploy.qrcode.exception;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.updeploy.qrcode.dto.ResponseFail;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GeneralErroHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseFail> Exception(Exception e, HttpServletRequest request) {
    ResponseFail responseFail = new ResponseFail(e, request);
    return ResponseEntity.status(responseFail.getStatus()).body(responseFail);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<ResponseFail> handleNoSuchElementException(NoSuchElementException e, HttpServletRequest request) {
    ResponseFail responseFail = new ResponseFail(e, request);
    String[] requestPath = request.getRequestURI().split("/");
    responseFail.setDetail(String.format("%s with id %s not found", requestPath[1], requestPath[2]));
    return ResponseEntity.badRequest().body(responseFail);
  }

}
