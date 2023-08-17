package com.updeploy.qrcode.util;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class ContentValidator {
  
  public static void validateUrl(String url) throws Exception {

    // Validate Protocols
    String[] protocols = new String[] {
      "http://", "https://", "ftp://", "ftps://", "sftp://"
    };

    boolean isValid = false;

    for(String protocol : protocols) {
      if(url.startsWith(protocol)) {
        isValid = true;
        break;
      }
    }

    if(!isValid) {
      throw new UnknownHostException();
    }

    // Validate URL
    URL urlObject = new URL(url);
    InetAddress.getByName(urlObject.getHost());
  }
}
