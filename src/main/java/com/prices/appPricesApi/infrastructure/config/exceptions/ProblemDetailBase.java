package com.prices.appPricesApi.infrastructure.config.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.ProblemDetail;

@JsonIgnoreProperties(value = {
        "type",
        "instance"
})
public class ProblemDetailBase extends ProblemDetail {
}
