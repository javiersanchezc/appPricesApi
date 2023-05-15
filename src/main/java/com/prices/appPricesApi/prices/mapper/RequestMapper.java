package com.prices.appPricesApi.prices.mapper;


import com.prices.appPricesApi.prices.request.PriceRequestContext;
import com.prices.appPricesApi.prices.response.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RequestMapper {

    /**
     * Metodo el cual consulta los precios segun requerimiento
     *
     * @param priceRequestContext
     * @return
     */
    @Mapping(source = "priceRequest.appDate", target = "appDate")
    @Mapping(source = "priceRequest.brandId", target = "brandId")
    @Mapping(source = "price.finalPrice", target = "finalPrice")
    @Mapping(source = "price.priceList", target = "price")
    @Mapping(source = "price.productId", target = "productId")
    PriceResponse of(PriceRequestContext priceRequestContext);

}
