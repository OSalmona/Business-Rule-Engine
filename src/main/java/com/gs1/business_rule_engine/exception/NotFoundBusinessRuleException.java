package com.gs1.business_rule_engine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class NotFoundBusinessRuleException extends RuntimeException{
    public NotFoundBusinessRuleException(String message){
        super(message);
    }
}
