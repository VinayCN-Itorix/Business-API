package com.banking.business.Service;

import io.apiwiz.compliance.config.EnableCompliance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@EnableCompliance
@RequestMapping("/api")
class TransferService {

@PostMapping("1.0/transfer")
public ResponseEntity<?> createTransfer(@RequestBody Map<String, Object> request) {
    Map<String, Object> responseMap = Map.of(
            "id", "630f95f7-a3f9-abf2-b4e4-3f65281234dc",
            "state", "pending",
            "created_at", "2020-11-23T08:39:35.811005Z",
            "completed_at", ""
    );
    return new ResponseEntity<>(responseMap, HttpStatus.CREATED);
}
}