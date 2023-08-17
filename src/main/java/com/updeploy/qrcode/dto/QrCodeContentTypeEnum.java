package com.updeploy.qrcode.dto;

public enum QrCodeContentTypeEnum {
  URL("U"),
  TEXT("T"),
  EMAIL("E"),
  PHONE("P"),
  PIX("P");

  private final String value;

  QrCodeContentTypeEnum(String value) {
    System.out.println(value);
    this.value = value;
  }

  public String value() {
    return value;
  }

  public static QrCodeContentTypeEnum fromValue(String value) {
    for (QrCodeContentTypeEnum qrCodeContentTypeEnum : QrCodeContentTypeEnum.values()) {
      if (qrCodeContentTypeEnum.value.equals(value)) {
        return qrCodeContentTypeEnum;
      }
    }
    throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + allowedValues());
  }

  private static String allowedValues() {
    return String.join(", ", QrCodeContentTypeEnum.values().toString());
  }
  
}
