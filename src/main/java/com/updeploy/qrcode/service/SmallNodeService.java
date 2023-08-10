package com.updeploy.qrcode.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.updeploy.qrcode.repository.SmallNodeRepository;
import com.updeploy.qrcode.dto.SmallNodeRequestDTO;
import com.updeploy.qrcode.entity.SmallNodeEntity;

@Service
public class SmallNodeService {

  @Autowired
  private SmallNodeRepository smallNodeRepository;

  public List<SmallNodeEntity> getAll() {
    List<SmallNodeEntity> smallNodeList = smallNodeRepository.findAll();

    return smallNodeList;
  }

  public SmallNodeEntity getById(String uuid) {
    UUID uuidObj = UUID.fromString(uuid);

    SmallNodeEntity smallNode = smallNodeRepository.findById(uuidObj).orElseThrow();

    return smallNode;
  }

  public SmallNodeEntity create(SmallNodeRequestDTO smallNodeRequest) {
    SmallNodeEntity smallNode = new SmallNodeEntity(smallNodeRequest);

    return smallNodeRepository.save(smallNode);
  }

  public SmallNodeEntity updatePatch(String uuid, SmallNodeRequestDTO smallNodeRequestDTO) {
    UUID uuidObj = UUID.fromString(uuid);

    SmallNodeEntity smallNode = smallNodeRepository.findById(uuidObj).orElseThrow();

    smallNode.setBigNodeUuid(smallNodeRequestDTO.bigNodeUuid());

    return smallNodeRepository.save(smallNode);
  }

  public void delete(String uuid) {
    UUID uuidObj = UUID.fromString(uuid);

    SmallNodeEntity smallNode = smallNodeRepository.findById(uuidObj).orElseThrow();

    smallNodeRepository.delete(smallNode);
  }
  
}
