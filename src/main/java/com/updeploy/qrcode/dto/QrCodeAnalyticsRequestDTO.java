package com.updeploy.qrcode.dto;

import java.util.UUID;

public record QrCodeAnalyticsRequestDTO(UUID qrCodeUuid, String analytics, String description, String value) {
  
}
