package com.gs1.business_rule_engine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class TransactionDTO {
    private String id;
    private String direction;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime transactionDate;
    private String transactionType;
    private String status;
}
