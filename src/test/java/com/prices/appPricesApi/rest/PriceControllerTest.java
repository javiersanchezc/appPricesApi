package com.prices.appPricesApi.rest;

import com.prices.appPricesApi.prices.PriceService;
import com.prices.appPricesApi.prices.request.PriceRequest;
import com.prices.appPricesApi.prices.response.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceControllerTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPrice_at10AM_onDay14_forProduct35455_andBrand1() {
        // Arrange
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 14, 10, 0);
        PriceRequest expectedRequest = PriceRequest.builder()
                .appDate(dateTime)
                .productId(35455)
                .brandId(1)
                .build();
        PriceResponse expectedResponse = new PriceResponse(/* your expected response data */);
        when(priceService.getPrice(expectedRequest)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<PriceResponse> response = priceController.getPrice(dateTime, 35455, 1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testGetPrice_at4PM_onDay14_forProduct35455_andBrand1() {
        // Arrange
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 14, 16, 0);
        PriceRequest expectedRequest = PriceRequest.builder()
                .appDate(dateTime)
                .productId(35455)
                .brandId(1)
                .build();
        PriceResponse expectedResponse = new PriceResponse(/* your expected response data */);
        when(priceService.getPrice(expectedRequest)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<PriceResponse> response = priceController.getPrice(dateTime, 35455, 1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    // Similarly, you can write test methods for the other test cases (testGetPrice_at21PM_onDay14_forProduct35455_andBrand1,
    // testGetPrice_at10AM_onDay15_forProduct35455_andBrand1, testGetPrice_at21PM_onDay16_forProduct35455_andBrand1)
    // following the same pattern as shown above.
    @Test
    void testGetPrice_at9PM_onDay14_forProduct35455_andBrand1() {
        // Arrange
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 14, 21, 0);
        PriceRequest expectedRequest = PriceRequest.builder()
                .appDate(dateTime)
                .productId(35455)
                .brandId(1)
                .build();
        PriceResponse expectedResponse = new PriceResponse(/* your expected response data */);
        when(priceService.getPrice(expectedRequest)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<PriceResponse> response = priceController.getPrice(dateTime, 35455, 1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testGetPrice_at10AM_onDay15_forProduct35455_andBrand1() {
        // Arrange
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 15, 10, 0);
        PriceRequest expectedRequest = PriceRequest.builder()
                .appDate(dateTime)
                .productId(35455)
                .brandId(1)
                .build();
        PriceResponse expectedResponse = new PriceResponse(/* your expected response data */);
        when(priceService.getPrice(expectedRequest)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<PriceResponse> response = priceController.getPrice(dateTime, 35455, 1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testGetPrice_at9PM_onDay16_forProduct35455_andBrand1() {
        // Arrange
        LocalDateTime dateTime = LocalDateTime.of(2023, 5, 16, 21, 0);
        PriceRequest expectedRequest = PriceRequest.builder()
                .appDate(dateTime)
                .productId(35455)
                .brandId(1)
                .build();
        PriceResponse expectedResponse = new PriceResponse(/* your expected response data */);
        when(priceService.getPrice(expectedRequest)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<PriceResponse> response = priceController.getPrice(dateTime, 35455, 1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

}
