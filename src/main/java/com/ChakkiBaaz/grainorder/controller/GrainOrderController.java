package com.ChakkiBaaz.grainorder.controller;
import com.ChakkiBaaz.grainorder.payload.GrainOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/grain-orders")
public class GrainOrderController {
    private final RestTemplate restTemplate;


    public GrainOrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestBody GrainOrderDTO grainOrderDTO) {
        double amount = grainOrderDTO.getQuantity() * grainOrderDTO.getPricePerKg();
        grainOrderDTO.setAmount(amount);

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/cart/addToCart", grainOrderDTO, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Grain order added to cart successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add grain order to cart");
        }
    }
}
