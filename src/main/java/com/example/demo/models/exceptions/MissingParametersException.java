package com.example.demo.models.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "You have not provided query parameters for filtering")
public class MissingParametersException extends RuntimeException{
}
