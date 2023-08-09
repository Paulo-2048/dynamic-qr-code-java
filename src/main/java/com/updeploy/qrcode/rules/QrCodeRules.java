package com.updeploy.qrcode.rules;

import com.updeploy.qrcode.dto.QrCodeRequestDTO;
import com.updeploy.qrcode.dto.QrCodeStatusEnum;
import com.updeploy.qrcode.dto.QrCodeTypeEnum;

public class QrCodeRules {
  
  public static void preInsert(QrCodeRequestDTO qrCodeRequestDTO) throws Exception {

    if(qrCodeRequestDTO.type() == QrCodeTypeEnum.STATIC && qrCodeRequestDTO.status() == QrCodeStatusEnum.INACTIVE)
      throw new Exception("Static qr code only can be created with status active");
      
  }

  public static void preUpdate(QrCodeRequestDTO oldQrCodeRequestDTO, QrCodeRequestDTO newQrCodeRequestDTO) throws Exception {
    
    if(oldQrCodeRequestDTO.type() == QrCodeTypeEnum.STATIC){
      if(newQrCodeRequestDTO.type() == QrCodeTypeEnum.DYNAMIC)
        throw new Exception("Static qr code, can't be updated to dynamic type");
      
      if(newQrCodeRequestDTO.status() == QrCodeStatusEnum.INACTIVE)
        throw new Exception("Static qr code, can't be updated to inactive status");

      if(newQrCodeRequestDTO.content() != null && newQrCodeRequestDTO.content() != oldQrCodeRequestDTO.content())
        throw new Exception("Static qr code, can't be updated content");
    }
  }
}
