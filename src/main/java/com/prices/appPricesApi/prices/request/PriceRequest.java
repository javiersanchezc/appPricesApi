package com.prices.appPricesApi.prices.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Contiene informacion base para realizar la consulta
 */
@Data
@Builder
@Setter
@Getter
public class PriceRequest {
    private LocalDateTime appDate;
    private Integer productId;
    private Integer brandId;

}
