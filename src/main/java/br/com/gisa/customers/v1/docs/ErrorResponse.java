package br.com.gisa.customers.v1.docs;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final String message;
    private final String datetime;

    public ErrorResponse(String message) {
        this.message = message;
        this.datetime = LocalDateTime.now().toString();
    }

}