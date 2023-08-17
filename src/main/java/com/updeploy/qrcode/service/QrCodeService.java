package com.updeploy.qrcode.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.updeploy.qrcode.dto.QrCodeContentTypeEnum;
import com.updeploy.qrcode.dto.QrCodeRequestDTO;
import com.updeploy.qrcode.dto.QrCodeTypeEnum;
import com.updeploy.qrcode.entity.QrCodeEntity;
import com.updeploy.qrcode.repository.QrCodeRepository;
import com.updeploy.qrcode.rule.QrCodeRules;
import com.updeploy.qrcode.util.ContentValidator;

@Service
public class QrCodeService {

  @Autowired
  private QrCodeRepository qrCodeRepository;

  public List<QrCodeEntity> getAll() throws Exception {
    List<QrCodeEntity> qrCodeList = qrCodeRepository.findAll();

    return qrCodeList;
  }

  public QrCodeEntity getById(String uuid) throws Exception {
    UUID uuidObj = UUID.fromString(uuid);

    QrCodeEntity qrCode = qrCodeRepository.findById(uuidObj).orElseThrow();

    return qrCode;
  }

  public QrCodeEntity create(QrCodeRequestDTO qrCodeRequest) throws Exception {
    QrCodeEntity qrCode = new QrCodeEntity(qrCodeRequest);

    if (qrCode.getContentType().equals(QrCodeContentTypeEnum.URL)) {
      ContentValidator.validateUrl(qrCode.getContent());
    }

    return qrCodeRepository.save(qrCode);
  }

  public QrCodeEntity updatePatch(String uuid, QrCodeRequestDTO qrCodeRequestDTO) throws Exception {
    UUID uuidObj = UUID.fromString(uuid);

    QrCodeEntity qrCode = qrCodeRepository.findById(uuidObj).orElseThrow();

    QrCodeRules.preUpdate(qrCode.toQrCodeRequestDTO(), qrCodeRequestDTO);

    qrCode.setSnoUuid(qrCodeRequestDTO.snoUuid() == null ? qrCode.getSnoUuid() : qrCodeRequestDTO.snoUuid());
    qrCode.setName(qrCodeRequestDTO.name() == null ? qrCode.getName() : qrCodeRequestDTO.name());
    qrCode.setDescription(
        qrCodeRequestDTO.description() == null ? qrCode.getDescription() : qrCodeRequestDTO.description());
    qrCode.setContent(qrCodeRequestDTO.content() == null ? qrCode.getContent() : qrCodeRequestDTO.content());
    qrCode.setPrivacy(qrCodeRequestDTO.privacy() == null ? qrCode.getPrivacy() : qrCodeRequestDTO.privacy());
    qrCode.setStatus(qrCodeRequestDTO.status() == null ? qrCode.getStatus() : qrCodeRequestDTO.status());

    return qrCodeRepository.save(qrCode);
  }

  public QrCodeEntity updatePut(String uuid, QrCodeRequestDTO qrCodeRequestDTO) throws Exception {
    UUID uuidObj = UUID.fromString(uuid);

    QrCodeEntity qrCode = qrCodeRepository.findById(uuidObj).orElseThrow();

    QrCodeRules.preUpdate(qrCode.toQrCodeRequestDTO(), qrCodeRequestDTO);

    qrCode.setSnoUuid(qrCodeRequestDTO.snoUuid());
    qrCode.setName(qrCodeRequestDTO.name());
    qrCode.setDescription(qrCodeRequestDTO.description());
    //Todo Mover para rules
    if (qrCode.getType() == QrCodeTypeEnum.DYNAMIC) { 
      qrCode.setContent(qrCodeRequestDTO.content());
      qrCode.setPrivacy(qrCodeRequestDTO.privacy());
      qrCode.setStatus(qrCodeRequestDTO.status());
    }

    return qrCodeRepository.save(qrCode);
  }

  public void delete(String uuid) throws Exception {
    UUID uuidObj = UUID.fromString(uuid);

    QrCodeEntity qrCode = qrCodeRepository.findById(uuidObj).orElseThrow();

    qrCodeRepository.delete(qrCode);
  }

}
