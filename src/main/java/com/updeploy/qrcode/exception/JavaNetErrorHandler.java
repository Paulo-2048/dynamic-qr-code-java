package com.updeploy.qrcode.exception;

import java.net.UnknownHostException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.updeploy.qrcode.dto.ResponseFail;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class JavaNetErrorHandler {

  @ExceptionHandler(UnknownHostException.class)
  public ResponseEntity<ResponseFail> handleUnknownHostException(UnknownHostException e, HttpServletRequest request) {
    ResponseFail responseFail = new ResponseFail(e, request);
    String[] requestPath = request.getRequestURI().split("/");
    responseFail.setTitle("Invalid URL");
    responseFail.setDetail(String.format("Redirect URL to %s reference, is invalid", requestPath[1]));
    return ResponseEntity.badRequest().body(responseFail);
  }
  
}
