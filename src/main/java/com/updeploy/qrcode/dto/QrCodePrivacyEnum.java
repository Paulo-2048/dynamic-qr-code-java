package com.updeploy.qrcode.dto;

public enum QrCodePrivacyEnum {
  PUBLIC("P"),
  RESTRICTED("R");

  private final String value;

  QrCodePrivacyEnum(String value) {
    System.out.println(value);
    this.value = value;
  }

  public String value() {
    System.out.println("SSS");
    return value;
  }

  public static QrCodePrivacyEnum fromValue(String value) {
    for (QrCodePrivacyEnum qrCodePrivacyEnum : QrCodePrivacyEnum.values()) {
      if (qrCodePrivacyEnum.value.equals(value)) {
        return qrCodePrivacyEnum;
      }
    }
    throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + allowedValues());
  }

  private static String allowedValues() {
    return String.join(", ", QrCodePrivacyEnum.values().toString());
  }
  
}
