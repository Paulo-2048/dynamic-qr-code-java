package com.updeploy.qrcode.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.updeploy.qrcode.dto.QrCodeRequestDTO;
import com.updeploy.qrcode.dto.QrCodeTypeEnum;
import com.updeploy.qrcode.rules.QrCodeRules;
import com.updeploy.qrcode.utils.referenceManager;
import com.updeploy.qrcode.dto.QrCodePrivacyEnum;
import com.updeploy.qrcode.dto.QrCodeStatusEnum;

@Table(name = "QRC_qr_code")
@Entity(name = "QRC_qr_code")
@Getter
@Setter
public class QrCodeEntity {

  @Id @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "qrc_uuid")
  private UUID uuid;

  @Column(name = "qrc_sno_uuid")
  private UUID snoUuid;

  @Column(name = "qrc_name")
  private String name;
  
  @Column(name = "qrc_description")
  private String description;

  @Column(name = "qrc_content")
  private String content;

  @Column(name = "qrc_reference")
  private String reference;

  @Column(name = "qrc_privacy")
  @Enumerated(EnumType.STRING)
  private QrCodePrivacyEnum privacy;


  @Column(name = "qrc_type")
  @Enumerated(EnumType.STRING)
  private QrCodeTypeEnum type;

  @Column(name = "qrc_status")
  @Enumerated(EnumType.STRING)
  private QrCodeStatusEnum status;

  @CreationTimestamp
  @Column(name = "qrc_create_date")
  private LocalDateTime createDate;

  @UpdateTimestamp
  @Column(name = "qrc_update_date")
  private LocalDateTime updateDate;

  public QrCodeRequestDTO toQrCodeRequestDTO() {
    return new QrCodeRequestDTO(
      this.snoUuid,
      this.name,
      this.description,
      this.content,
      this.privacy,
      this.type,
      this.status
    );
  }

  public QrCodeEntity() {
  }

  public QrCodeEntity(QrCodeRequestDTO qrCodeRequestDTO) throws Exception {

    QrCodeRules.preInsert(qrCodeRequestDTO);
    
    this.snoUuid = qrCodeRequestDTO.snoUuid();
    this.name = qrCodeRequestDTO.name();
    this.description = qrCodeRequestDTO.description();
    this.content = qrCodeRequestDTO.content();
    this.reference = referenceManager.generateReference();
    this.privacy = qrCodeRequestDTO.privacy();
    this.type = qrCodeRequestDTO.type();
    this.status = qrCodeRequestDTO.status();
  }

  public void UpdateTotalQrCode(QrCodeRequestDTO qrCodeRequestDTO) throws Exception {

    QrCodeRules.preUpdate(this.toQrCodeRequestDTO(), qrCodeRequestDTO);

    this.snoUuid = qrCodeRequestDTO.snoUuid();
    this.name = qrCodeRequestDTO.name();
    this.description = qrCodeRequestDTO.description();
    this.content = qrCodeRequestDTO.content();
    this.privacy = qrCodeRequestDTO.privacy();
    this.type = qrCodeRequestDTO.type();
    this.status = qrCodeRequestDTO.status();
  }

  public void UpdateParcialQrCode(QrCodeRequestDTO qrCodeRequestDTO) throws Exception {

   //QrCodeRules.preUpdate(this.toQrCodeRequestDTO(), qrCodeRequestDTO);

   this.snoUuid = qrCodeRequestDTO.snoUuid() == null ? this.snoUuid : qrCodeRequestDTO.snoUuid();
   this.name = qrCodeRequestDTO.name() == null ? this.name : qrCodeRequestDTO.name();
   this.description = qrCodeRequestDTO.description() == null ? this.description : qrCodeRequestDTO.description();
   this.content = qrCodeRequestDTO.content() == null ? this.content : qrCodeRequestDTO.content();
   this.privacy = qrCodeRequestDTO.privacy() == null ? this.privacy : qrCodeRequestDTO.privacy();
   this.type = qrCodeRequestDTO.type() == null ? this.type : qrCodeRequestDTO.type();
   this.status = qrCodeRequestDTO.status() == null ? this.status : qrCodeRequestDTO.status();
  }

}
