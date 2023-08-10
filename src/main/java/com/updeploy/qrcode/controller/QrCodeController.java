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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.updeploy.qrcode.dto.ResponseSuccess;
import com.updeploy.qrcode.dto.ApiResponse;
import com.updeploy.qrcode.dto.QrCodeRequestDTO;
import com.updeploy.qrcode.entity.QrCodeEntity;
import com.updeploy.qrcode.service.QrCodeService;


@RestController
@RequestMapping("qrcode")
public class QrCodeController {

  @Autowired
  private QrCodeService qrCodeService;

  @GetMapping
  public ResponseEntity<ApiResponse> getAll() throws Exception {
      List<QrCodeEntity> qrCodeList = qrCodeService.getAll();

      return ResponseEntity.ok(new ResponseSuccess("Get qr code list success", qrCodeList));
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<ApiResponse> getById(@PathVariable("uuid") String uuid) throws Exception {
    QrCodeEntity qrCode = qrCodeService.getById(uuid);

    return ResponseEntity.ok(new ResponseSuccess("Get qr code success", qrCode));
  }

  @PostMapping
  public ResponseEntity<ApiResponse> create(@RequestBody QrCodeRequestDTO qrCodeRequest) throws Exception {
    QrCodeEntity qrCodeInstance = qrCodeService.create(qrCodeRequest);

    return ResponseEntity.ok(new ResponseSuccess("Create qr code success", qrCodeInstance));
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<ApiResponse> update(@PathVariable("uuid") String uuid,
      @RequestBody QrCodeRequestDTO qrCodeRequest) throws Exception {
    QrCodeEntity qrCodeInstance = qrCodeService.updatePut(uuid, qrCodeRequest);

    return ResponseEntity.ok(new ResponseSuccess("Update qr code success", qrCodeInstance));
  }

  @PatchMapping("/{uuid}")
  public ResponseEntity<ApiResponse> updatePartial(@PathVariable("uuid") String uuid,
      @RequestBody QrCodeRequestDTO qrCodeRequest) throws Exception {
    QrCodeEntity qrCodeInstance = qrCodeService.updatePatch(uuid, qrCodeRequest);

    return ResponseEntity.ok(new ResponseSuccess("Update qr code success", qrCodeInstance));
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<ApiResponse> delete(@PathVariable("uuid") String uuid) throws Exception {
    qrCodeService.delete(uuid);

    return ResponseEntity.ok(new ResponseSuccess("Delete qr code success").OnlyMessage());
  }
}