package com.updeploy.qrcode.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.updeploy.qrcode.entity.QrCodeAnalyticsEntity;

public interface QrCodeAnalyticsRepository extends JpaRepository<QrCodeAnalyticsEntity, UUID> {
  
}
