package com.updeploy.qrcode.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.updeploy.qrcode.entity.QrCodeEntity;
import com.updeploy.qrcode.repository.QrCodeRepository;
import com.updeploy.qrcode.util.ContentValidator;

@Service
public class RedirectService {

  @Autowired
  private QrCodeRepository qrCodeRepository;

  public String getRetirectByReference(String reference) throws Exception {
    QrCodeEntity qrCode = qrCodeRepository.findByReference(reference).orElseThrow();

    ContentValidator.validateUrl(qrCode.getContent());

    return qrCode.getContent();
  }
}
