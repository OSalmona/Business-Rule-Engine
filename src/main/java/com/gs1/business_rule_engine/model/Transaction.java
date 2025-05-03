package com.gs1.business_rule_engine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    private String id;
    private String direction;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime transactionDate;
    private String transactionType;
    private String status;

}
