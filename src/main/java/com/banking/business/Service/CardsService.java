package com.banking.business.Service;

import io.apiwiz.compliance.config.EnableCompliance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@EnableCompliance
@RequestMapping("/business-card")
public class CardsService {

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
            Map.entry("accounts", List.of("f52c6c84-26b9-4e95-bbcf-99ed6523fb51")),
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
            Map.entry("accounts", List.of("f52c6c84-26b9-4e95-bbcf-99ed6523fb51")),
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
public ResponseEntity<Map<String, Object>> createCard(@RequestBody Map<String, Object> cardMetadata) {
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
            Map.entry("accounts", List.of("f52c6c84-26b9-4e95-bbcf-99ed6523fb51")),
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
    
    return new ResponseEntity<>(cardMetadata,HttpStatus.CREATED);
}

@GetMapping("/api/1.0/cards")
public ResponseEntity<?> listCards(
        @RequestParam(value = "limit", required = false) Integer limit,
        @RequestParam(value = "created_before", required = false) String createdBefore,
        @RequestHeader(value = "deviate",required = false) boolean deviate
) {
    if(deviate){
        Map<String, Object> cardData = Map.ofEntries(
                Map.entry("id", "aa14a9af-d7a7-4214-a743-lok818f74bd0"),
                Map.entry("last_digits", "2671"),
                Map.entry("expiry", "09/2027"),
                Map.entry("state", "active"),
                Map.entry("holder_id", "2121212-5af1-42c8-bece-3d28nlmo894d"),
                Map.entry("label", "Kirby Janette"),
                Map.entry("virtual", true),
                Map.entry("product", Map.ofEntries(
                        Map.entry("code", "MBJ")
                )),
                Map.entry("accounts", List.of(
                        "2121212-5af1-42c8-bece-3d28nlmo894d"
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
        
        return new ResponseEntity<>(cardData, HttpStatus.OK);
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
    
    return new ResponseEntity<>(cardData, HttpStatus.OK);
}
}