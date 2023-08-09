package com.updeploy.qrcode.dto;

public enum QrCodeTypeEnum {
  STATIC("S"),
  DYNAMIC("D");

  private final String value;

  QrCodeTypeEnum(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
