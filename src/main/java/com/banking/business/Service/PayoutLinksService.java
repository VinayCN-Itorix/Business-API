package com.banking.business.Service;

import io.apiwiz.compliance.config.EnableCompliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableCompliance
@RequestMapping("/v1/business-payouts/api/1.0/payout-links")
class PayoutLinksService {
@Value("${api.post.create.payment:null}")
private String createPayment ;
@Autowired
private RestTemplate restTemplate;
@GetMapping
public ResponseEntity<?> getPayoutLinks() {
    List<Map<String, Object>> transactions = List.of(
            Map.ofEntries(
                    Map.entry("id", "8e32b08a-e012-4530-bd15-c4e9ebde953d"),
                    Map.entry("state", "processed"),
                    Map.entry("created_at", "2024-01-11T14:02:53.472318Z"),
                    Map.entry("updated_at", "2024-01-11T14:05:02.962886Z"),
                    Map.entry("counterparty_name", "Jane Doe"),
                    Map.entry("request_id", "5a7fcb46-4be4-47d4-a56f-27a2e5b78dMM"),
                    Map.entry("expiry_date", "2023-07-18T14:02:53.717626Z"),
                    Map.entry("payout_methods", List.of(
                            "revolut",
                            "bank_account",
                            "card"
                    )),
                    Map.entry("account_id", "85f515e4-588f-4496-a6a5-a7615a193e6b"),
                    Map.entry("amount", 5.6),
                    Map.entry("currency", "GBP"),
                    Map.entry("counterparty_id", "2ef4618a-f258-4ac5-a846-ca6e089214f6"),
                    Map.entry("transaction_id", "64ad618e-655a-a925-8425-2284c03f6c08"),
                    Map.entry("reference", "Bus ticket"),
                    Map.entry("transfer_reason_code", "travel")
            ),
            Map.ofEntries(
                    Map.entry("id", "12dcd8c2-6408-458f-98a9-3f4abc180898"),
                    Map.entry("state", "active"),
                    Map.entry("created_at", "2023-07-11T13:55:54.834963Z"),
                    Map.entry("updated_at", "2023-07-11T14:02:12.868346Z"),
                    Map.entry("counterparty_name", "John Doe"),
                    Map.entry("request_id", "5a7fcb46-4be4-47d4-a56f-27a2e5b78dd1"),
                    Map.entry("expiry_date", "2023-07-18T13:55:55.082280Z"),
                    Map.entry("payout_methods", List.of(
                            "revolut",
                            "bank_account"
                    )),
                    Map.entry("account_id", "85f515e4-588f-4496-a6a5-a7615a193e6b"),
                    Map.entry("amount", 105.6),
                    Map.entry("currency", "GBP"),
                    Map.entry("url", "https://business.revolut.com/p/uSJVAd5SnP1"),
                    Map.entry("reference", "Rent"),
                    Map.entry("transfer_reason_code", "property_rental")
            ),
            Map.ofEntries(
                    Map.entry("id", "d3b02315-044c-471f-ad41-59d9a4e3c538"),
                    Map.entry("state", "active"),
                    Map.entry("created_at", "2023-07-11T13:53:45.986248Z"),
                    Map.entry("updated_at", "2023-07-11T13:53:46.475470Z"),
                    Map.entry("counterparty_name", "John Smith"),
                    Map.entry("request_id", "rev-001"),
                    Map.entry("expiry_date", "2023-07-18T13:53:46.474777Z"),
                    Map.entry("payout_methods", List.of(
                            "revolut"
                    )),
                    Map.entry("account_id", "85f515e4-588f-4496-a6a5-a7615a193e6b"),
                    Map.entry("amount", 15.6),
                    Map.entry("currency", "GBP"),
                    Map.entry("url", "https://business.revolut.com/p/DPYtd2BUUwP"),
                    Map.entry("reference", "meal delivery")
            )
    );
    return new ResponseEntity<>(transactions, HttpStatus.OK);
}

@GetMapping("/{payoutLinkId}")
public ResponseEntity<?> getPayoutLinkById(@PathVariable String payoutLinkId) {
    Map<String, Object> transaction = Map.ofEntries(
            Map.entry("id", "12dcd8c2-6408-458f-98a9-3f4abc180898"),
            Map.entry("state", "active"),
            Map.entry("created_at", "2023-07-11T13:55:54.834963Z"),
            Map.entry("updated_at", "2023-07-11T13:55:55.082655Z"),
            Map.entry("counterparty_name", "John Smith"),
            Map.entry("request_id", "5a7fcb46-4be4-47d4-a56f-27a2e5b78dd1"),
            Map.entry("expiry_date", "2023-07-18T13:55:55.082280Z"),
            Map.entry("payout_methods", List.of(
                    "revolut",
                    "bank_account",
                    "card"
            )),
            Map.entry("account_id", "85f515e4-588f-4496-a6a5-a7615a193e6b"),
            Map.entry("amount", 105.6),
            Map.entry("currency", "GBP"),
            Map.entry("url", "https://business.revolut.com/p/uSJVAd5SnP1"),
            Map.entry("reference", "Rent"),
            Map.entry("transfer_reason_code", "property_rental")
    );
    return new ResponseEntity<>(transaction, HttpStatus.OK);
}

@PostMapping
public ResponseEntity<?> createPayoutLink(@RequestBody Map<String, Object> requestData,  @RequestHeader(value = "enableTracing",required = false)boolean enableTracing) throws URISyntaxException {
    Map<String, Object> transaction = Map.ofEntries(
            Map.entry("counterparty_name", "John Smith"),
            Map.entry("save_counterparty", false),
            Map.entry("request_id", "5a7fcb46-4be4-47d4-a56f-27a2e5b78dd1"),
            Map.entry("account_id", "85f515e4-588f-4496-a6a5-a7615a193e6b"),
            Map.entry("amount", 105.6),
            Map.entry("currency", "GBP"),
            Map.entry("reference", "Rent"),
            Map.entry("payout_methods", List.of(
                    "revolut",
                    "bank_account",
                    "card"
            )),
            Map.entry("expiry_period", "P3D"),
            Map.entry("transfer_reason_code", "property_rental")
    );
    if(enableTracing){
        Map<String, Object> requestPayload = new LinkedHashMap<String, Object>() {{
            put("request_id", "0d14fb2a-4079-4187-89ea-d915e16b4a1d");
            put("account_id", "b7ec67d3-5af1-42c8-bece-3d28nlmo894d");
            put("receiver", new LinkedHashMap<String, Object>() {{
                put("counterparty_id", "a1d2a938-c69b-4f08-b15f-bfc1b54b69d1");
                put("account_id", "417433c2-d930-47a0-ad34-a88b01939ce5");
            }});
            put("amount", 10);
            put("currency", "EUR");
            put("charge_bearer", "shared");
            put("reference", "To John Doe");
        }};
        HttpHeaders headers  = new HttpHeaders();
        headers.add("enableTracing",String.valueOf(Boolean.TRUE));
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestPayload, headers);
        restTemplate.exchange(new URI(createPayment), HttpMethod.POST, httpEntity, Object.class);
    }
    return new ResponseEntity<>(transaction, HttpStatus.CREATED);
}

@PostMapping("/{payoutLinkId}/cancel")
public ResponseEntity<?> cancelPayoutLink(@PathVariable String payoutLinkId) {
    return new ResponseEntity<>(HttpStatus.OK);
}

@GetMapping("/transfer-reasons")
public ResponseEntity<?> getTransferReasons() {
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
    return new ResponseEntity<>(dataList, HttpStatus.OK);
}
}