package com.updeploy.qrcode.repository;

import com.updeploy.qrcode.entity.BigNodeEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BigNodeRepository extends JpaRepository<BigNodeEntity, UUID> {
  
}
