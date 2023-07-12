package com.updeploy.qrcode.dto;

public class ResponseSuccess extends ApiResponse {

  private Object data;
  
  public ResponseSuccess(String message) {
    super(message);
  }

  public ResponseSuccess(String message, Object data) {
    super(message);
    this.data = data;
  }
  
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public ApiResponse OnlyMessage() {
    return new ApiResponse(getMessage());
  }
}
