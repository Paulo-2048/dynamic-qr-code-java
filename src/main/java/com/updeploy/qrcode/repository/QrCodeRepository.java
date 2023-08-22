package com.updeploy.qrcode.repository;

import java.util.Optional;
import java.util.UUID;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.updeploy.qrcode.entity.QrCodeEntity;

public interface QrCodeRepository extends JpaRepository<QrCodeEntity, UUID> {

  public Optional<QrCodeEntity> findByReference(String reference);

  public List<QrCodeEntity> findBySnoUuid(UUID snoUuid);

  @Query("""
  SELECT qr.name FROM QRCode qr
  INNER JOIN SmallNode sno ON qr.snoUuid = sno.uuid
  INNER JOIN BigNode bno ON sno.bigNodeUuid = bno.uuid
  WHERE bno.uuid = :bnoUuid
  """)
  public List<QrCodeEntity> findAllByBnoUuid(@Param("bnoUuid") UUID bnoUuid);
  
}



  // INNER JOIN SmallNode ON QRCode.sno_uuid = SmallNode.uuid
  // INNER JOIN BigNode ON SmallNode.bno_uuid = BigNode.uuid
  // WHERE BigNode.bno_uuid = :bnoUuid