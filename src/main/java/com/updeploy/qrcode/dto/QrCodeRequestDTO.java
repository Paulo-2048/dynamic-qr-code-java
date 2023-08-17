package com.updeploy.qrcode.dto;

import java.util.UUID;

public record QrCodeRequestDTO(UUID snoUuid, String name, String description, String content, QrCodeContentTypeEnum contentType, QrCodePrivacyEnum privacy, QrCodeTypeEnum type, QrCodeStatusEnum status) {
  
}
