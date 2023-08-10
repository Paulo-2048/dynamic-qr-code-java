package com.updeploy.qrcode.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.updeploy.qrcode.entity.BigNodeEntity;
import com.updeploy.qrcode.repository.BigNodeRepository;

@Service
public class BigNodeService {

  @Autowired
  private BigNodeRepository bigNodeRepository;

  public List<BigNodeEntity> getAll() {
    List<BigNodeEntity> bigNodeList = bigNodeRepository.findAll();

    return bigNodeList;
  }

  public BigNodeEntity getById(String uuid) {
    UUID uuidObj = UUID.fromString(uuid);

    BigNodeEntity bigNode = bigNodeRepository.findById(uuidObj).orElseThrow();

    return bigNode;
  }

  public BigNodeEntity create() {
    BigNodeEntity bigNode = new BigNodeEntity();

    return bigNodeRepository.save(bigNode);
  }

  public void delete(String uuid) {
    UUID uuidObj = UUID.fromString(uuid);

    BigNodeEntity bigNode = bigNodeRepository.findById(uuidObj).orElseThrow();

    bigNodeRepository.delete(bigNode);
  }
}
