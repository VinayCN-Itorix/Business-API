package com.banking.business.Service;

import io.apiwiz.compliance.config.EnableCompliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@EnableCompliance
@RequestMapping("/api")
class TransferService {
@Value("${api.get.account.url:null}")
private String url ;

@Autowired
private RestTemplate restTemplate;

@PostMapping("1.0/transfer")
public ResponseEntity<?> createTransfer(@RequestBody Map<String, Object> request , @RequestHeader(value = "enableTracing",required = false)boolean enableTracing,
                                        @RequestHeader(value = "deviate", required = false) boolean deviate) throws URISyntaxException {
    Map<String, Object> responseMap = Map.of(
            "id", "630f95f7-a3f9-abf2-b4e4-3f65281234dc",
            "state", "pending",
            "created_at", "2020-11-23T08:39:35.811005Z",
            "completed_at", ""
    );
    if(enableTracing){
        HttpHeaders headers = new HttpHeaders();
        headers.add("enableTracing",String.valueOf(Boolean.TRUE));
        headers.add("deviate",String.valueOf(deviate));
        restTemplate.exchange(new URI(url), HttpMethod.GET,new HttpEntity<>(headers),Object.class);
    }
    return new ResponseEntity<>(responseMap, HttpStatus.CREATED);
}
}