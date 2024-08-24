package com.banking.business.Service;

import io.apiwiz.compliance.config.EnableCompliance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@EnableCompliance
@RequestMapping("/business-accounts/api/1.0/accounts")
public class AccountsService {

@GetMapping
public ResponseEntity<?> getAllAccounts() {
    // Return a static response for all accounts
   List<Map<String,Object>> response =  Collections.singletonList(
            Map.of(
                    "id", "2e6de1bf-97ad-478d-aad1-9d7a3cdf1234",
                    "name", "International account",
                    "balance", 3171.89,
                    "currency", "GBP",
                    "state", "active",
                    "public", false,
                    "created_at", "2022-08-05T14:29:22.215785Z",
                    "updated_at", "2022-08-05T14:29:22.215785Z"
            )
    );
    return new ResponseEntity<>(response,HttpStatus.OK);
}

@GetMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<?> getAccountById(@PathVariable("id") String id) {
    // Return a static response for a specific account
    Map<String, Object> response = Map.of(
            "id", "b7ec67d3-5af1-42c8-bece-3d28nlmo894d",
            "name", "International account",
            "balance", 3171.89,
            "currency", "GBP",
            "state", "active",
            "public", false,
            "created_at", "2022-08-05T14:29:22.215785Z",
            "updated_at", "2022-08-05T14:29:22.215785Z"
    );
    return new ResponseEntity<>(response,HttpStatus.OK);
}

@GetMapping("/{id}/bank-details")
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<?> getBankDetailsById(@PathVariable("id") String id) {
    List<Map<String, Object>> response = Collections.singletonList(
            Map.of(
                    "iban", "GB66REVO00996995908888",
                    "bic", "REVOGB21",
                    "beneficiary", "International account",
                    "beneficiary_address", Map.of(
                            "street_line1", "Revolut LTD",
                            "street_line2", "1 Canada Square",
                            "city", "London",
                            "country", "GB",
                            "postcode", "E14 5AB"
                    ),
                    "bank_country", "GB",
                    "pooled", false,
                    "schemes", List.of("swift"),
                    "estimated_time", Map.of(
                            "unit", "days",
                            "min", 1,
                            "max", 3
                    )
            )
    );
    return new ResponseEntity<>(response,HttpStatus.OK);
}
}
