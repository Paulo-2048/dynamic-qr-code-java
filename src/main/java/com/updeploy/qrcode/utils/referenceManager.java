package com.updeploy.qrcode.utils;

public class referenceManager {
  
  public static String generateReference() {
    String reference = "";
    String[] characters = new String[] {
      "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
      "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
      "U", "V", "X", "W", "Y", "Z", "1", "2", "3", "4",
      "5", "6", "7", "8", "9", "0"
    };

    for(int i = 0; i < 6; i++) {
      int random = (int) (Math.random() * characters.length);
      reference += characters[random];
    }

    return reference;
  }
}
