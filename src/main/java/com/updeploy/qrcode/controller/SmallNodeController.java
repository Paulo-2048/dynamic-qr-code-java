package com.updeploy.qrcode.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.updeploy.qrcode.dto.ResponseSuccess;
import com.updeploy.qrcode.dto.SmallNodeRequestDTO;
import com.updeploy.qrcode.dto.ResponseFail;
import com.updeploy.qrcode.dto.ApiResponse;
import com.updeploy.qrcode.entity.SmallNodeEntity;
import com.updeploy.qrcode.repository.SmallNodeRepository;


@RestController
@RequestMapping("smallnode")
public class SmallNodeController {
  

  @Autowired
  private SmallNodeRepository smallNodeRepository;

  @GetMapping
  public ResponseEntity<ApiResponse> getAll() {
    try {
      List<SmallNodeEntity> smallNodeList = smallNodeRepository.findAll();

      if(smallNodeList.isEmpty())
        throw new Exception("Small node list is empty");

      return ResponseEntity.ok(new ResponseSuccess("Get all small node success", smallNodeList));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Get all small node fail"));
    }
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<ApiResponse> getById(@PathVariable("uuid") String uuid) {
    try {
      UUID uuidObj = UUID.fromString(uuid);
      SmallNodeEntity smallNode = smallNodeRepository.findById(uuidObj).orElse(null);

      if(smallNode == null)
        throw new Exception("Small node not found");

      return ResponseEntity.ok(new ResponseSuccess("Get small node success", smallNode));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Get small node fail"));
    }
  }

  @PostMapping
  public ResponseEntity<ApiResponse> create(@RequestBody SmallNodeRequestDTO smallNodeRequest) {
    try {
      SmallNodeEntity newSmallNodeEntity = new SmallNodeEntity(smallNodeRequest);
      SmallNodeEntity smallNodeCreated = smallNodeRepository.save(newSmallNodeEntity);

      return ResponseEntity.ok(new ResponseSuccess("Create small node success", smallNodeCreated));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Create small node fail"));
    }
  }

  @PatchMapping("/{uuid}")
  public ResponseEntity<ApiResponse> update(@PathVariable("uuid") String uuid, @RequestBody SmallNodeRequestDTO smallNodeRequest) {
    try {
      UUID uuidObj = UUID.fromString(uuid);
      SmallNodeEntity smallNode = smallNodeRepository.findById(uuidObj).orElse(null);

      if(smallNode == null)
        throw new Exception("Small node not found");

        smallNode.setBigNodeUuid(smallNodeRequest.bigNodeUuid());
        SmallNodeEntity smallNodeUpdated = smallNodeRepository.save(smallNode);

      return ResponseEntity.ok(new ResponseSuccess("Update small node success", smallNodeUpdated));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Update small node fail"));
    }
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<ApiResponse> delete(@PathVariable("uuid") String uuid) {
    try {
      UUID uuidObj = UUID.fromString(uuid);
      SmallNodeEntity smallNode = smallNodeRepository.findById(uuidObj).orElse(null);

      if(smallNode == null)
        throw new Exception("Small node not found");

      smallNodeRepository.delete(smallNode);

      return ResponseEntity.ok(new ResponseSuccess("Delete small node success").OnlyMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Delete small node fail"));
    }
  }
}
