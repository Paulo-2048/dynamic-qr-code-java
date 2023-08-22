package com.updeploy.qrcode.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.updeploy.qrcode.dto.SmallNodeRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// -- Tabela SNO_small_node
// CREATE TABLE SNO_small_node
// (
//     sno_uuid        UUID PRIMARY KEY DEFAULT gen_random_uuid(),
//     sno_bno_uuid    UUID REFERENCES BNO_big_node (bno_uuid),
//     sno_create_date TIMESTAMP        DEFAULT NOW(),
//     sno_update_date TIMESTAMP        DEFAULT NOW(),
//     CONSTRAINT fk_sno_bno FOREIGN KEY (sno_bno_uuid) REFERENCES public.BNO_big_node (bno_uuid) ON DELETE CASCADE ON UPDATE CASCADE,
//     INDEX ind_pk_sno (sno_uuid ASC),
//     INDEX ind_fk_sno_bno (sno_bno_uuid ASC)
// );


@Table(name = "SNO_small_node")
@Entity(name = "SmallNode")
@Getter
@Setter
public class SmallNodeEntity {
  

  @Id @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "sno_uuid")
  private UUID uuid;

  @Column(name = "sno_bno_uuid")
  private UUID bigNodeUuid;

  @Column(name = "sno_create_date")
  @CreationTimestamp
  private LocalDateTime createDate;

  @Column(name = "sno_update_date")
  @UpdateTimestamp
  private LocalDateTime updateDate;


  public SmallNodeEntity() {
  }

  public SmallNodeEntity(SmallNodeRequestDTO smallNodeRequestDTO) {
    this.bigNodeUuid = smallNodeRequestDTO.bigNodeUuid();
  }
}
