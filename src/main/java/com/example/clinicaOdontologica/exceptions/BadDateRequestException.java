package com.example.clinicaOdontologica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadDateRequestException extends Exception{

    public BadDateRequestException(String message) {
         super(message);
    }


}
