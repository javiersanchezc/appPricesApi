package com.prices.appPricesApi.rest;


import com.prices.appPricesApi.prices.request.PriceRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetPrice() throws Exception {
        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1)
                .productId(1)
                .appDate(LocalDateTime.parse("2023-05-15T20:42:58.663", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();

        String jsonRequest = objectMapper.writeValueAsString(priceRequest);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title", is("Not Found")))
                .andExpect(jsonPath("$.status", is(404)))
                .andExpect(jsonPath("$.detail", is("La combinacion de [brand, product_id y fecha de la aplicacion] son invalidas")));
    }
    @Test
    public void testGetPrice_10am_day14() throws Exception {
        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1)
                .productId(1)
                .appDate(LocalDateTime.parse("2023-05-14T10:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();

        String jsonRequest = objectMapper.writeValueAsString(priceRequest);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title", is("Not Found")))
                .andExpect(jsonPath("$.status", is(404)))
                .andExpect(jsonPath("$.detail", is("La combinacion de [brand, product_id y fecha de la aplicacion] son invalidas")));

        // Add more mockMvc.perform blocks for other test cases...
    }


    @Test
    public void testGetPrice_4pm_day14() throws Exception {
        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1)
                .productId(1)
                .appDate(LocalDateTime.parse("2023-05-14T16:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();

        String jsonRequest = objectMapper.writeValueAsString(priceRequest);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("Not Found"))
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.detail").value("La combinacion de [brand, product_id y fecha de la aplicacion] son invalidas"));

        // Add more mockMvc.perform blocks for other test cases...
    }


    @Test
    public void testGetPrice_9pm_day14() throws Exception {
        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1)
                .productId(1)
                .appDate(LocalDateTime.parse("2023-05-14T21:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();

        String jsonRequest = objectMapper.writeValueAsString(priceRequest);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("Not Found"))
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.detail").value("La combinacion de [brand, product_id y fecha de la aplicacion] son invalidas"));

        // Add more mockMvc.perform blocks for other test cases...
    }

    @Test
    public void testGetPrice_10am_day15() throws Exception {
        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1)
                .productId(1)
                .appDate(LocalDateTime.parse("2023-05-15T10:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();

        String jsonRequest = objectMapper.writeValueAsString(priceRequest);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("Not Found"))
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.detail").value("La combinacion de [brand, product_id y fecha de la aplicacion] son invalidas"));

        // Add more mockMvc.perform blocks for other test cases...
    }

    @Test
    public void testGetPrice_9pm_day16() throws Exception {
        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1)
                .productId(1)
                .appDate(LocalDateTime.parse("2023-05-16T21:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();

        String jsonRequest = objectMapper.writeValueAsString(priceRequest);

        mockMvc.perform(get("/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("Not Found"))
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.detail").value("La combinacion de [brand, product_id y fecha de la aplicacion] son invalidas"));

        // Add more mockMvc.perform blocks for other test cases...
    }

}