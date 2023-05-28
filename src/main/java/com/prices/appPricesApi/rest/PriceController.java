package com.prices.appPricesApi.rest;

import com.prices.appPricesApi.prices.PriceService;
import com.prices.appPricesApi.prices.request.PriceRequest;
import com.prices.appPricesApi.prices.response.PriceResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Validated
public class PriceController {

    private final PriceService priceService;

    @GetMapping(value = "/price")
    public @ResponseBody ResponseEntity<PriceResponse> getPrice(
            @Valid @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime appDate,
            @RequestParam Integer productId, @RequestParam Integer brandId) {
        if (appDate == null) {
            appDate = LocalDateTime.now();  // set a default value
        }
        PriceRequest priceRequest = PriceRequest.builder()
                .appDate(appDate)
                .productId(productId)
                .brandId(brandId)
                .build();
        PriceResponse price = priceService.getPrice(priceRequest);
        return ResponseEntity.ok(price);
    }


}
