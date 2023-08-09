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


@Table(name = "BNO_big_node")
@Entity(name = "BNO_big_node")
@Getter
@Setter
public class BigNodeEntity {
  
  @Id @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "bno_uuid")
  private UUID uuid;

  @Column(name = "bno_create_date")
  @CreationTimestamp
  private LocalDateTime createDate;

  @Column(name = "bno_update_date")
  @UpdateTimestamp
  private LocalDateTime updateDate;

}
