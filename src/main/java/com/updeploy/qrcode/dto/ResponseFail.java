package com.updeploy.qrcode.dto;

import java.time.Instant;
import java.util.NoSuchElementException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ResponseFail {

  @Getter
  private String title;

  @Getter
  private int status;

  @Getter
  private String detail;

  @Getter
  private Instant timestamp;

  @Getter
  private String instace;

  private String requestMethod;
  private String[] requestUri;

  public ResponseFail(Exception e, HttpServletRequest request) {
    this.requestMethod = request.getMethod();
    this.requestUri = request.getRequestURI().split("/");

    setTitleByRequest();
    setDetailByRequest();
    setStatusCodeByException(e);
    this.timestamp = Instant.now();
    this.instace = request.getRequestURI();
  }

  private void setTitleByRequest() {
    this.title = "Error in request to " + requestUri[1] + " route.";
  }

  //Todo - Improve Later, implement open/closed principle?
  private void setDetailByRequest() { 
    String requestOperation;
    
    switch (requestMethod) {
      case "GET":
        if (requestUri.length >= 3) {
          requestOperation = "search";
        } else {
          requestOperation = "list";
        }
        break;
      case "POST":
        requestOperation = "create";
        break;
      case "PUT":
        requestOperation = "update";
        break;
      case "PATCH":
        requestOperation = "update";
        break;
      case "DELETE":
        requestOperation = "delete";
        break;
      default:
        requestOperation = "operation";
        break;
    }

    this.detail = "An error occurred while processing your request to " + requestOperation + " the " + requestUri[1] + " resource.";
  }

  //Todo - Improve Later, implement open/closed principle?
  private void setStatusCodeByException(Exception e) {
    if (e instanceof NoSuchElementException) {
      this.status = 404;
     } else {
      this.status = 400;
    }
  }

}
