package com.updeploy.qrcode.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.updeploy.qrcode.entity.BigNodeEntity;

public record BigNodeResponseDTO(
    UUID id,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {

  public BigNodeResponseDTO(BigNodeEntity entity) {
    this(
        entity.getUuid(),
        entity.getCreateDate(),
        entity.getUpdateDate());
  }
}
