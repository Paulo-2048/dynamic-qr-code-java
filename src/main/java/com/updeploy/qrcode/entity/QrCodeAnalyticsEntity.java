package com.updeploy.qrcode.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.updeploy.qrcode.dto.QrCodeAnalyticsRequestDTO;


@Table(name = "QCA_qr_code_analytics")
@Entity(name = "QCA_qr_code_analytics")
@Getter
@Setter
public class QrCodeAnalyticsEntity {
  
  @Id @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "qca_uuid")
  private UUID uuid;

  @Column(name = "qca_qrc_uuid")
  private UUID qrCodeUuid;

  @Column(name = "qca_analytics")
  private String analytics;

  @Column(name = "qca_description")
  private String description;

  @Column(name = "qca_value")
  private String value;

  @CreationTimestamp
  @Column(name = "qca_create_date")
  private LocalDateTime createDate;

  @UpdateTimestamp
  @Column(name = "qca_update_date")
  private LocalDateTime updateDate;

  public QrCodeAnalyticsEntity() {
  }

  public QrCodeAnalyticsEntity(QrCodeAnalyticsRequestDTO qrCodeAnalyticsRequestDTO) {
    this.qrCodeUuid = qrCodeAnalyticsRequestDTO.qrCodeUuid();
    this.analytics = qrCodeAnalyticsRequestDTO.analytics();
    this.description = qrCodeAnalyticsRequestDTO.description();
    this.value = qrCodeAnalyticsRequestDTO.value();
  }
}
