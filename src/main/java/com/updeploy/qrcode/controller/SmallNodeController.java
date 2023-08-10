package com.updeploy.qrcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
import com.updeploy.qrcode.dto.ApiResponse;
import com.updeploy.qrcode.entity.SmallNodeEntity;
import com.updeploy.qrcode.service.SmallNodeService;

@RestController
@RequestMapping("smallnode")
public class SmallNodeController {

  @Autowired
  private SmallNodeService smallNodeService;

  @GetMapping
  public ResponseEntity<ApiResponse> getAll() {
    List<SmallNodeEntity> smallNodeList = smallNodeService.getAll();

    return ResponseEntity.ok(new ResponseSuccess("Get small node list success", smallNodeList));
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<ApiResponse> getById(@PathVariable("uuid") String uuid) {
    SmallNodeEntity smallNode = smallNodeService.getById(uuid);

    return ResponseEntity.ok(new ResponseSuccess("Get small node success", smallNode));
  }

  @PostMapping
  public ResponseEntity<ApiResponse> create(@RequestBody SmallNodeRequestDTO smallNodeRequest) {
    SmallNodeEntity smallNodeInstance = smallNodeService.create(smallNodeRequest);

    return ResponseEntity.ok(new ResponseSuccess("Create small node success", smallNodeInstance));
  }

  @PatchMapping("/{uuid}")
  public ResponseEntity<ApiResponse> update(@PathVariable("uuid") String uuid,
      @RequestBody SmallNodeRequestDTO smallNodeRequest) {
    SmallNodeEntity smallNodeInstance = smallNodeService.updatePatch(uuid, smallNodeRequest);

    return ResponseEntity.ok(new ResponseSuccess("Update small node success", smallNodeInstance));
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<ApiResponse> delete(@PathVariable("uuid") String uuid) {
    smallNodeService.delete(uuid);

    return ResponseEntity.ok(new ResponseSuccess("Delete small node success").OnlyMessage());
  }
}
