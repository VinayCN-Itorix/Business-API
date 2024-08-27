package com.banking.business.Service;

import io.apiwiz.compliance.config.EnableCompliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableCompliance
@RequestMapping("/business-card")
public class CardsService {
@Value("${api.post.payout.link:null}")
private String payoutUrl ;
@Value("${api.post.create.card:null}")
private String createCardUrl;
@Value("${api.post.create.payment:null}")
private String createPayment ;

@Autowired
private RestTemplate restTemplate;
@PostMapping("/api/1.0/cards/{card_id}/unfreeze")
public ResponseEntity<Void> unfreezeCard(@PathVariable String card_id) {
   
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@PostMapping("/api/1.0/cards/{card_id}/freeze")
public ResponseEntity<Void> freezeCard(@PathVariable String card_id) {
    // Static response
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@GetMapping("/api/1.0/cards/{card_id}")
public ResponseEntity<Map<String, Object>> getCardDetails(@PathVariable String card_id) {
    Map<String, Object> cardDetailsData = Map.ofEntries(
            Map.entry("id", "aa14a9af-d7a7-4214-a743-lok818f74bd0"),
            Map.entry("last_digits", "2671"),
            Map.entry("expiry", "09/2027"),
            Map.entry("state", "active"),
            Map.entry("holder_id", "173ab846-de2a-1234-5678-160bd2e660e6"),
            Map.entry("label", "Kirby Janette"),
            Map.entry("virtual", true),
            Map.entry("product", Map.ofEntries(
                    Map.entry("code", "MBJ")
            )),
            Map.entry("accounts", List.of("b7ec67d3-5af1-42c8-bece-3d28nlmo894d")),
            Map.entry("categories", List.of("restaurants", "groceries")),
            Map.entry("spending_limits", Map.ofEntries(
                    Map.entry("single", Map.ofEntries(
                            Map.entry("amount", 200.22),
                            Map.entry("currency", "GBP")
                    )),
                    Map.entry("week", Map.ofEntries(
                            Map.entry("amount", 200.44),
                            Map.entry("currency", "GBP")
                    ))
            )),
            Map.entry("created_at", "2022-09-15T11:04:11.047305Z"),
            Map.entry("updated_at", "2022-09-15T11:04:11.047305Z")
    );
    
    
    return new ResponseEntity<>(cardDetailsData,HttpStatus.OK);
}

@PatchMapping("/api/1.0/cards/{card_id}")
public ResponseEntity<Map<String, Object>> updateCardDetails(
        @PathVariable String card_id,
        @RequestBody Map<String, Object> cardDetails
) {
    Map<String, Object> updatedCardDetailsData = Map.ofEntries(
            Map.entry("id", "aa14a9af-d7a7-4214-a743-lok818f74bd0"),
            Map.entry("last_digits", "2671"),
            Map.entry("expiry", "09/2027"),
            Map.entry("state", "active"),
            Map.entry("holder_id", "173ab846-de2a-1234-5678-160bd2e660e6"),
            Map.entry("label", "New card label"),
            Map.entry("virtual", true),
            Map.entry("product", Map.ofEntries(
                    Map.entry("code", "MBJ")
            )),
            Map.entry("accounts", List.of("b7ec67d3-5af1-42c8-bece-3d28nlmo894d")),
            Map.entry("categories", List.of("services", "shopping", "furniture")),
            Map.entry("spending_limits", Map.ofEntries(
                    Map.entry("single", Map.ofEntries(
                            Map.entry("amount", 100),
                            Map.entry("currency", "GBP")
                    )),
                    Map.entry("week", Map.ofEntries(
                            Map.entry("amount", 300),
                            Map.entry("currency", "GBP")
                    ))
            )),
            Map.entry("created_at", "2022-09-15T11:04:11.047305Z"),
            Map.entry("updated_at", "2024-08-17T08:32:11.024721Z")
    );
    
    return new ResponseEntity<>(updatedCardDetailsData,HttpStatus.ACCEPTED);
}

@DeleteMapping("/api/1.0/cards/{card_id}")
public ResponseEntity<Void> terminateCard(@PathVariable String card_id) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@GetMapping("/api/1.0/cards/{card_id}/sensitive-details")
public ResponseEntity<Map<String, Object>> getSensitiveCardDetails(@PathVariable String card_id) {
    Map<String, Object> cardSensitiveDetails = Map.ofEntries(
            Map.entry("pan", "4111111111111111"),
            Map.entry("cvv", "123"),
            Map.entry("expiry", "06/2025")
    );
    
    return new ResponseEntity<>(cardSensitiveDetails,HttpStatus.OK);
}

@PostMapping("/api/1.0/cards")
public ResponseEntity<Map<String, Object>> createCard(@RequestBody Map<String, Object> cardMetadata,
                                                      @RequestHeader(value = "enableTracing",required = false) boolean enableTracing,
                                                      @RequestHeader(value = "deviate", required = false) boolean deviate) throws URISyntaxException {
    // Static response
    Map<String, Object> cardDetailsData = Map.ofEntries(
            Map.entry("id", "aa14a9af-d7a7-4214-a743-lok818f74bd0"),
            Map.entry("last_digits", "2671"),
            Map.entry("expiry", "09/2027"),
            Map.entry("state", "active"),
            Map.entry("holder_id", "173ab846-de2a-1234-5678-160bd2e660e6"),
            Map.entry("label", "Kirby Janette"),
            Map.entry("virtual", true),
            Map.entry("product", Map.ofEntries(
                    Map.entry("code", "MBJ")
            )),
            Map.entry("accounts", List.of("b7ec67d3-5af1-42c8-bece-3d28nlmo894d")),
            Map.entry("categories", List.of("restaurants", "groceries")),
            Map.entry("spending_limits", Map.ofEntries(
                    Map.entry("single", Map.ofEntries(
                            Map.entry("amount", 200.22),
                            Map.entry("currency", "GBP")
                    )),
                    Map.entry("week", Map.ofEntries(
                            Map.entry("amount", 200.44),
                            Map.entry("currency", "GBP")
                    ))
            )),
            Map.entry("created_at", "2022-09-15T11:04:11.047305Z"),
            Map.entry("updated_at", "2022-09-15T11:04:11.047305Z")
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
        headers.add("deviate",String.valueOf(deviate));
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestPayload, headers);
        restTemplate.exchange(new URI(createPayment), HttpMethod.POST, httpEntity, Object.class);
    }
    return new ResponseEntity<>(cardMetadata,HttpStatus.CREATED);
}

@GetMapping("/api/1.0/cards")
public ResponseEntity<?> listCards(
        @RequestParam(value = "limit", required = false) Integer limit,
        @RequestParam(value = "created_before", required = false) String createdBefore,
        @RequestHeader(value = "deviate",required = false) boolean deviate,
        @RequestHeader(value = "enableTracing",required = false) boolean enableTracing
) throws URISyntaxException {
    if(deviate){
        Map<String, Object> card = null;
        if(enableTracing){ //create a new  card
            HttpHeaders headers =new HttpHeaders();
            Map<String, Object> requestPayload = new LinkedHashMap<>() {{
                put("request_id", "7a10f3eb-fe56-4699-9bd0-044a63508828");
                put("virtual", true);
                put("holder_id", "173ab846-de2a-1234-5678-160bd2e660e6");
                put("label", "Kirby Janette");
                put("accounts", new String[]{"75aa436d-2a04-4ab9-af14-ed0955769b8c"});
                put("categories", new String[]{"groceries", "restaurants"});
                put("spending_limits", new LinkedHashMap<String, Map<String, Object>>() {{
                    put("single", new LinkedHashMap<String, Object>() {{
                        put("amount", 200.22);
                        put("currency", "GBP");
                    }});
                    put("week", new LinkedHashMap<String, Object>() {{
                        put("amount", 200.44);
                        put("currency", "GBP");
                    }});
                }});
            }};
            headers.add("enableTracing",String.valueOf(Boolean.TRUE));
            HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestPayload, headers);
            restTemplate.exchange(new URI(createCardUrl), HttpMethod.POST, httpEntity, Object.class);
        }
        return new ResponseEntity<>(card, HttpStatus.OK);
    }
    Map<String, Object> cardData = Map.ofEntries(
            Map.entry("id", "aa14a9af-d7a7-4214-a743-lok818f74bd0"),
            Map.entry("last_digits", "2671"),
            Map.entry("expiry", "09/2027"),
            Map.entry("state", "active"),
            Map.entry("holder_id", "b7ec67d3-5af1-42c8-bece-3d28nlmo894d"),
            Map.entry("label", "Kirby Janette"),
            Map.entry("virtual", true),
            Map.entry("product", Map.ofEntries(
                    Map.entry("code", "MBJ")
            )),
            Map.entry("accounts", List.of(
                    "b7ec67d3-5af1-42c8-bece-3d28nlmo894d"
            )),
            Map.entry("categories", List.of(
                    "restaurants",
                    "groceries"
            )),
            Map.entry("spend_program", Map.ofEntries(
                    Map.entry("label", "Office supplies")
            )),
            Map.entry("spending_limits", Map.ofEntries(
                    Map.entry("single", Map.ofEntries(
                            Map.entry("amount", 200.22),
                            Map.entry("currency", "GBP")
                    )),
                    Map.entry("month", Map.ofEntries(
                            Map.entry("amount", 200.44),
                            Map.entry("currency", "GBP")
                    ))
            )),
            Map.entry("created_at", "2022-09-15T11:04:11.047305Z"),
            Map.entry("updated_at", "2024-08-17T08:32:11.024721Z")
    );
    if(enableTracing){ //create a payout link
        HttpHeaders headers =new HttpHeaders();
        Map<String, Object> req = new LinkedHashMap<String, Object>() {{
            put("counterparty_name", "John Smith");
            put("save_counterparty", false);
            put("request_id", "ceeeabce-c89b-4558-9ba7-e25191454844");
            put("account_id", "b7ec67d3-5af1-42c8-bece-3d28nlmo894d");
            put("amount", 10);
            put("currency", "GBP");
            put("reference", "Rent");
            put("payout_methods", new String[]{"card"});
            put("expiry_period", "P3D");
            put("transfer_reason_code", "property_rental");
        }};
        headers.add("enableTracing",String.valueOf(Boolean.TRUE));
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(req, headers);
        restTemplate.exchange(new URI(payoutUrl), HttpMethod.POST, httpEntity, Object.class);
    }
    return new ResponseEntity<>(cardData, HttpStatus.OK);
}
}