package com.lucasgalliani.qrcode.generator.controller;

import com.google.zxing.WriterException;
import com.lucasgalliani.qrcode.generator.dto.QrCodeGenerateRequest;
import com.lucasgalliani.qrcode.generator.dto.QrCodeGenerateResponse;
import com.lucasgalliani.qrcode.generator.service.QrCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrcodeService;

    public QrCodeController(QrCodeGeneratorService qrcodeService) {
        this.qrcodeService = qrcodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request) {

        try {
            QrCodeGenerateResponse response = this.qrcodeService.generateUploadQrCode(request.text());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
