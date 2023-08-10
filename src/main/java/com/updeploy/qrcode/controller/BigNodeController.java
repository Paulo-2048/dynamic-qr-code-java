package com.updeploy.qrcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.updeploy.qrcode.dto.ResponseSuccess;
import com.updeploy.qrcode.dto.ApiResponse;
import com.updeploy.qrcode.entity.BigNodeEntity;
import com.updeploy.qrcode.service.BigNodeService;

@RestController
@RequestMapping("bignode")
public class BigNodeController {

  @Autowired
  private BigNodeService bigNodeService;

  @GetMapping
  public ResponseEntity<ApiResponse> getAll() {
    List<BigNodeEntity> bigNodeList = bigNodeService.getAll();

    return ResponseEntity.ok(new ResponseSuccess("Get big node list success", bigNodeList));
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<ApiResponse> getById(@PathVariable("uuid") String uuid) {
    BigNodeEntity bigNode = bigNodeService.getById(uuid);

    return ResponseEntity.ok(new ResponseSuccess("Get big node success", bigNode));
  }

  @PostMapping
  public ResponseEntity<ApiResponse> create() {
    BigNodeEntity bigNodeInstance = bigNodeService.create();

    return ResponseEntity.ok(new ResponseSuccess("Create big node success", bigNodeInstance));
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<ApiResponse> delete(@PathVariable("uuid") String uuid) {
    bigNodeService.delete(uuid);

    return ResponseEntity.ok(new ResponseSuccess("Delete big node success").OnlyMessage());
  }

}
