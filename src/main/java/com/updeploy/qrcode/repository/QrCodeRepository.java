package com.updeploy.qrcode.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.updeploy.qrcode.entity.QrCodeEntity;

public interface QrCodeRepository extends JpaRepository<QrCodeEntity, UUID> {

  Optional<QrCodeEntity> findByReference(String reference);
  
}
