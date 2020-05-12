package com.example.demo.models.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "The uploaded file is empty")
public class EmptyFileException extends RuntimeException{
}
