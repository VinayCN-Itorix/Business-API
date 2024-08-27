package com.banking.business.Service;

import io.apiwiz.compliance.config.EnableCompliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RestController
@EnableCompliance
@RequestMapping("/v1/business-payments/api/1.0")
class PaymentsService {
@Value("${api.get.list.cards:null}")
private String getCardsUrl ;
@Autowired
private RestTemplate restTemplate;

@GetMapping("/transactions")
public ResponseEntity<?> getAllTransactions(
        @RequestParam(required = false) String from,
        @RequestParam(required = false) String to,
        @RequestParam(required = false) String counterparty,
        @RequestParam(required = false) String account,
        @RequestParam(required = false) String count,
        @RequestParam(required = false) String type) {
    
    List<Map<String, Object>> transferData = List.of(
            Map.of(
                    "id", "630f9890-95e3-add1-be4a-95f126988221",
                    "type", "transfer",
                    "state", "pending",
                    "request_id", "invoice00912345",
                    "created_at", "2022-08-31T17:21:20.364171Z",
                    "updated_at", "2022-08-31T17:21:20.364171Z",
                    "reference", "invoice00912345",
                    "legs", List.of(
                            Map.of(
                                    "leg_id", "630f9890-95e3-add1-0000-95f1269f0000",
                                    "account_id", "812fff9a-3b0c-4ad1-b41a-cc60899d9900",
                                    "counterparty", Map.of(
                                            "account_type", "revolut",
                                            "account_id", "e0af9f24-504c-4c5d-bd1d-07edf9f49876"
                                    ),
                                    "amount", -1.16,
                                    "currency", "EUR",
                                    "bill_amount", -1,
                                    "bill_currency", "GBP",
                                    "description", "To John Doe"
                            )
                    )
            )
    );
    return new ResponseEntity<>(transferData , HttpStatus.OK);
}

@GetMapping("/transaction/{id}")
public ResponseEntity<?> getTransactionById(@PathVariable("id") int id) {
    Map<String, Object> exchangeData = Map.of(
            "id", "640dc0b7-1234-xxxx-1234-92ac4de1dacd",
            "type", "exchange",
            "state", "completed",
            "request_id", "d8f041ab-1234-xxxx-1234-78b6a0b2801f",
            "created_at", "2023-03-12T12:08:07.833414Z",
            "updated_at", "2023-03-12T12:08:07.833414Z",
            "completed_at", "2023-03-12T12:08:07.833705Z",
            "legs", List.of(
                    Map.of(
                            "leg_id", "640dc0a7-xxxx-a5b5-xxxx-92ac4de1dacd",
                            "account_id", "0d1848dc-xxxx-4a9a-xxxx-cae53cbd4baf",
                            "amount", -1,
                            "currency", "GBP",
                            "bill_amount", -8.39,
                            "bill_currency", "DKK",
                            "description", "Exchanged to DKK",
                            "balance", 8.74
                    ),
                    Map.of(
                            "leg_id", "640dc0a7-xxxx-a5b5-xxxx-92ac4de1dacd",
                            "account_id", "246bc9de-xxxx-4f86-xxxx-4d291a5d0390",
                            "amount", 8.39,
                            "fee", 0.08,
                            "currency", "DKK",
                            "description", "Exchanged from GBP Main",
                            "balance", 19.33
                    )
            )
    );
    
    return new ResponseEntity<>(exchangeData, HttpStatus.OK);
}

@DeleteMapping("/transaction/{id}")
public ResponseEntity<Void> cancelTransaction(@PathVariable("id") int id) {
    return new ResponseEntity<>(HttpStatus.OK);
}

@PostMapping("/pay")
public ResponseEntity<?> createPayment(@RequestBody Map<String, Object> paymentRequest) {
    Map<String, String> data = Map.of(
            "id", "630f9a62-e488-a9ce-a2d3-a30kkkke03f0",
            "state", "completed",
            "created_at", "2022-08-31T17:29:06.625613Z"
    );
    return new ResponseEntity<>(data, HttpStatus.OK);
}

@GetMapping("/transfer-reasons")
public ResponseEntity<?> getTransferReasons(@RequestHeader(value = "enableTracing",required = false) boolean enableTracing,
                                            @RequestHeader(value = "deviate", required = false) boolean deviate) throws URISyntaxException {
    List<Map<String, String>> dataList = List.of(
            Map.of("country", "IN", "currency", "INR", "code", "advertising", "description", "Advertising"),
            Map.of("country", "IN", "currency", "INR", "code", "advisor_fees", "description", "Advisor fees"),
            Map.of("country", "IN", "currency", "INR", "code", "construction", "description", "Construction"),
            Map.of("country", "IN", "currency", "INR", "code", "delivery", "description", "Delivery"),
            Map.of("country", "IN", "currency", "INR", "code", "family", "description", "Family"),
            Map.of("country", "IN", "currency", "INR", "code", "goods", "description", "Goods"),
            Map.of("country", "IN", "currency", "INR", "code", "exports", "description", "Goods from overseas"),
            Map.of("country", "IN", "currency", "INR", "code", "insurance_claims", "description", "Insurance claims"),
            Map.of("country", "IN", "currency", "INR", "code", "office", "description", "Office"),
            Map.of("country", "IN", "currency", "INR", "code", "other_fees", "description", "Other fees"),
            Map.of("country", "IN", "currency", "INR", "code", "royalties", "description", "Royalties"),
            Map.of("country", "IN", "currency", "INR", "code", "services", "description", "Services"),
            Map.of("country", "IN", "currency", "INR", "code", "personal_transfer", "description", "Transfer to my own account"),
            Map.of("country", "IN", "currency", "INR", "code", "transportation", "description", "Transportation"),
            Map.of("country", "IN", "currency", "INR", "code", "travel", "description", "Travel"),
            Map.of("country", "MY", "currency", "MYR", "code", "advertising", "description", "Advertising"),
            Map.of("country", "MY", "currency", "MYR", "code", "advisor_fees", "description", "Advisor fees"),
            Map.of("country", "MY", "currency", "MYR", "code", "business_insurance", "description", "Business insurance"),
            Map.of("country", "MY", "currency", "MYR", "code", "construction", "description", "Construction"),
            Map.of("country", "MY", "currency", "MYR", "code", "delivery", "description", "Delivery"),
            Map.of("country", "MY", "currency", "MYR", "code", "education", "description", "Education"),
            Map.of("country", "MY", "currency", "MYR", "code", "family", "description", "Family"),
            Map.of("country", "MY", "currency", "MYR", "code", "fund_investment", "description", "Fund investment"),
            Map.of("country", "MY", "currency", "MYR", "code", "exports", "description", "Goods from overseas"),
            Map.of("country", "MY", "currency", "MYR", "code", "homesend", "description", "Homesend"),
            Map.of("country", "MY", "currency", "MYR", "code", "hotel", "description", "Hotel"),
            Map.of("country", "MY", "currency", "MYR", "code", "insurance_claims", "description", "Insurance claims"),
            Map.of("country", "MY", "currency", "MYR", "code", "insurance_premium", "description", "Insurance premium"),
            Map.of("country", "MY", "currency", "MYR", "code", "loan_repayment", "description", "Loan repayment"),
            Map.of("country", "MY", "currency", "MYR", "code", "medical", "description", "Medical"),
            Map.of("country", "MY", "currency", "MYR", "code", "office", "description", "Office"),
            Map.of("country", "MY", "currency", "MYR", "code", "other_fees", "description", "Other fees"),
            Map.of("country", "MY", "currency", "MYR", "code", "property_purchase", "description", "Property purchase"),
            Map.of("country", "MY", "currency", "MYR", "code", "property_rental", "description", "Property rental"),
            Map.of("country", "MY", "currency", "MYR", "code", "royalties", "description", "Royalties"),
            Map.of("country", "MY", "currency", "MYR", "code", "services", "description", "Services"),
            Map.of("country", "MY", "currency", "MYR", "code", "share_investment", "description", "Share investment"),
            Map.of("country", "MY", "currency", "MYR", "code", "tax", "description", "Tax"),
            Map.of("country", "MY", "currency", "MYR", "code", "transfer", "description", "Transfer"),
            Map.of("country", "MY", "currency", "MYR", "code", "transportation", "description", "Transportation"),
            Map.of("country", "MY", "currency", "MYR", "code", "travel", "description", "Travel"),
            Map.of("country", "MY", "currency", "MYR", "code", "utilities", "description", "Utilities"),
            Map.of("country", "PH", "currency", "PHP", "code", "advertising", "description", "Advertising"),
            Map.of("country", "PH", "currency", "PHP", "code", "advisor_fees", "description", "Advisor fees"),
            Map.of("country", "PH", "currency", "PHP", "code", "construction", "description", "Construction"),
            Map.of("country", "PH", "currency", "PHP", "code", "delivery", "description", "Delivery"),
            Map.of("country", "PH", "currency", "PHP", "code", "family", "description", "Family"),
            Map.of("country", "PH", "currency", "PHP", "code", "goods", "description", "Goods"),
            Map.of("country", "PH", "currency", "PHP", "code", "exports", "description", "Goods from overseas"),
            Map.of("country", "PH", "currency", "PHP", "code", "insurance_claims", "description", "Insurance claims"),
            Map.of("country", "PH", "currency", "PHP", "code", "office", "description", "Office"),
            Map.of("country", "PH", "currency", "PHP", "code", "other_fees", "description", "Other fees"),
            Map.of("country", "PH", "currency", "PHP", "code", "royalties", "description", "Royalties"),
            Map.of("country", "PH", "currency", "PHP", "code", "services", "description", "Services"),
            Map.of("country", "PH", "currency", "PHP", "code", "personal_transfer", "description", "Transfer to my own account"),
            Map.of("country", "PH", "currency", "PHP", "code", "transportation", "description", "Transportation"),
            Map.of("country", "PH", "currency", "PHP", "code", "travel", "description", "Travel")
    );
    if(enableTracing){
        HttpHeaders headers = new HttpHeaders();
        headers.add("enableTracing",String.valueOf(Boolean.TRUE));
        headers.add("deviate",String.valueOf(deviate));
        restTemplate.exchange(new URI(getCardsUrl), HttpMethod.GET,new HttpEntity<>(headers),Object.class);
    }
    return new ResponseEntity<>(dataList, HttpStatus.OK);
}
}
