package com.updeploy.qrcode.exception;

import java.net.UnknownHostException;
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
    System.out.println(e.getMessage());
    return ResponseEntity.status(responseFail.getStatus()).body(responseFail);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<ResponseFail> handleNoSuchElementException(NoSuchElementException e, HttpServletRequest request) {
    ResponseFail responseFail = new ResponseFail(e, request);
    String[] requestPath = request.getRequestURI().split("/");

    if (requestPath.length >= 3)
      responseFail.setDetail(String.format("%s with id %s not found", requestPath[1], requestPath[2]));
      
    return ResponseEntity.badRequest().body(responseFail);
  }

  @ExceptionHandler(UnknownHostException.class)
  public ResponseEntity<ResponseFail> handleUnknownHostException(UnknownHostException e, HttpServletRequest request) {
    ResponseFail responseFail = new ResponseFail(e, request);
    String[] requestPath = request.getRequestURI().split("/");
    responseFail.setTitle("Invalid URL");
    responseFail.setDetail(String.format("Redirect URL to %s reference, is invalid", requestPath[1]));
    return ResponseEntity.badRequest().body(responseFail);
  }

}
