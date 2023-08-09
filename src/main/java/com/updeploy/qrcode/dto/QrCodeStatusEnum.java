package com.updeploy.qrcode.dto;

public enum QrCodeStatusEnum {
  ACTIVE("A"),
  INACTIVE("I");

  private final String value;

  QrCodeStatusEnum(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
