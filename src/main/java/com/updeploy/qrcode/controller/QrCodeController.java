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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.updeploy.qrcode.dto.ResponseSuccess;
import com.updeploy.qrcode.dto.ResponseFail;
import com.updeploy.qrcode.dto.ApiResponse;
import com.updeploy.qrcode.dto.QrCodeRequestDTO;
import com.updeploy.qrcode.entity.QrCodeEntity;
import com.updeploy.qrcode.repository.QrCodeRepository;


@RestController
@RequestMapping("qrcode")
public class QrCodeController {

  @Autowired
  private QrCodeRepository qrCodeRepository;

  @GetMapping
  public ResponseEntity<ApiResponse> getAll() {
    try {
      List<QrCodeEntity> qrCodeList = qrCodeRepository.findAll();

      if (qrCodeList.isEmpty())
        throw new Exception("Qr code list is empty");

      return ResponseEntity.ok(new ResponseSuccess("Get all qr code success", qrCodeList));
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.badRequest().body(new ResponseFail("Get all qr code fail"));
    }
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<ApiResponse> getById(@PathVariable("uuid") String uuid) {
    try {
      UUID uuidObj = UUID.fromString(uuid);
      QrCodeEntity qrCode = qrCodeRepository.findById(uuidObj).orElse(null);

      if (qrCode == null)
        throw new Exception("Qr code not found");

      return ResponseEntity.ok(new ResponseSuccess("Get qr code success", qrCode));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Get qr code fail"));
    }
  }

  @PostMapping
  public ResponseEntity<ApiResponse> create(@RequestBody QrCodeRequestDTO qrCodeRequest) {
    try {
      QrCodeEntity qrCode = new QrCodeEntity(qrCodeRequest);
      qrCodeRepository.save(qrCode);

      return ResponseEntity.ok(new ResponseSuccess("Create qr code success", qrCode));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Create qr code fail"));
    }
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<ApiResponse> update(@PathVariable("uuid") String uuid,
      @RequestBody QrCodeRequestDTO qrCodeRequest) {
    try {
      UUID uuidObj = UUID.fromString(uuid);
      QrCodeEntity qrCode = qrCodeRepository.findById(uuidObj).orElse(null);

      if (qrCode == null)
        throw new Exception("Qr code not found");

      qrCode.UpdateTotalQrCode(qrCodeRequest);
      qrCodeRepository.save(qrCode);

      return ResponseEntity.ok(new ResponseSuccess("Update qr code success", qrCode));
    } catch (Exception e) {
     System.out.println(e);
      return ResponseEntity.badRequest().body(new ResponseFail("Update qr code fail"));
    }
  }

  @PatchMapping("/{uuid}")
  public ResponseEntity<ApiResponse> updatePartial(@PathVariable("uuid") String uuid,
      @RequestBody QrCodeRequestDTO qrCodeRequest) {
    try {
      UUID uuidObj = UUID.fromString(uuid);
      QrCodeEntity qrCode = qrCodeRepository.findById(uuidObj).orElse(null);

      if (qrCode == null)
        throw new Exception("Qr code not found");

      qrCode.UpdateParcialQrCode(qrCodeRequest);
      qrCodeRepository.save(qrCode);

      return ResponseEntity.ok(new ResponseSuccess("Update qr code success", qrCode));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Update qr code fail"));
    }
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<ApiResponse> delete(@PathVariable("uuid") String uuid) {
    try {
      UUID uuidObj = UUID.fromString(uuid);
      QrCodeEntity qrCode = qrCodeRepository.findById(uuidObj).orElse(null);

      if (qrCode == null)
        throw new Exception("Qr code not found");

      qrCodeRepository.delete(qrCode);

      return ResponseEntity.ok(new ResponseSuccess("Delete qr code success").OnlyMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ResponseFail("Delete qr code fail"));
    }
  }
}
