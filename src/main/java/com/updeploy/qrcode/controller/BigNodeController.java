package com.updeploy.qrcode.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.updeploy.qrcode.dto.ResponseSuccess;
import com.updeploy.qrcode.dto.ResponseFail;
import com.updeploy.qrcode.dto.ApiResponse;
import com.updeploy.qrcode.entity.BigNodeEntity;
import com.updeploy.qrcode.repository.BigNodeRepository;

@RestController
@RequestMapping("bignode")
public class BigNodeController {
  

  @Autowired
  private BigNodeRepository bigNodeRepository;

  @GetMapping
  public ResponseEntity<ApiResponse> getAll() {
    try {
      List<BigNodeEntity> bigNodeList = bigNodeRepository.findAll();

      if(bigNodeList.isEmpty())
        throw new Exception("Big node list is empty");

      return ResponseEntity.ok(new ResponseSuccess("Get all big node success", bigNodeList));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Get all big node fail"));
    }
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<ApiResponse> getById(@PathVariable("uuid") String uuid) {
    try {

      UUID uuidObj = UUID.fromString(uuid);
      BigNodeEntity bigNode = bigNodeRepository.findById(uuidObj).orElse(null);

      if(bigNode == null)
        throw new Exception("Big node not found");

      return ResponseEntity.ok(new ResponseSuccess("Get big node success", bigNode));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Get big node fail"));
    }
  }

  @PostMapping
  public ResponseEntity<ApiResponse> create() {
    try {
      BigNodeEntity bigNode = new BigNodeEntity();

      bigNodeRepository.save(bigNode);

      return ResponseEntity.ok(new ResponseSuccess("Create big node success", bigNode));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Create big node fail"));
    }
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<ApiResponse> delete(@PathVariable("uuid") String uuid) {
    try {
      UUID uuidObj = UUID.fromString(uuid);
      BigNodeEntity bigNode = bigNodeRepository.findById(uuidObj).orElse(null);

      if(bigNode == null)
        throw new Exception("Big node not found");

      bigNodeRepository.delete(bigNode);

      return ResponseEntity.ok(new ResponseSuccess("Delete big node success").OnlyMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Delete big node fail"));
    }
  }

}
