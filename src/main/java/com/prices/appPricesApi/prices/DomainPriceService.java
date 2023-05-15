package com.prices.appPricesApi.prices;


import com.prices.appPricesApi.infrastructure.adapters.out.jpa.entity.Price;
import com.prices.appPricesApi.infrastructure.adapters.out.jpa.repository.PriceRepository;
import com.prices.appPricesApi.prices.exceptions.BrandProductAndDateNotFound;
import com.prices.appPricesApi.prices.mapper.RequestMapper;
import com.prices.appPricesApi.prices.request.PriceRequest;
import com.prices.appPricesApi.prices.request.PriceRequestContext;
import com.prices.appPricesApi.prices.response.PriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainPriceService implements PriceService {

    private final PriceRepository priceRepository;
    private final RequestMapper requestMapper;

    /**
     * El metodo getPrice tiene como responsabilidad filtrar mediante los paramtros
     * brandId / productId / appDate la informacion localizada en la db de memoria
     *
     * @param priceRequest Contiene informacion base para realizar la consulta
     * @return Optional<PriceResponse>
     */
    @Override
    public PriceResponse getPrice(PriceRequest priceRequest) {
        List<Price> prices = priceRepository.findByBrandProductAndDate(
                priceRequest.getBrandId(),
                priceRequest.getProductId(),
                priceRequest.getAppDate());

        if (!prices.isEmpty()) {
            Price price = prices.stream().max(Comparator.comparing(Price::getPriority)).get();
            return requestMapper.of(PriceRequestContext.builder()
                    .priceRequest(priceRequest)
                    .price(price)
                    .build());
        }

        throw new BrandProductAndDateNotFound();
    }

}
