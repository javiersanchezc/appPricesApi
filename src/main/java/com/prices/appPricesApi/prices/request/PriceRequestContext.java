package com.prices.appPricesApi.prices.request;


import com.prices.appPricesApi.infrastructure.adapters.out.jpa.entity.Price;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequestContext {

    private PriceRequest priceRequest;
    private Price price;
}
