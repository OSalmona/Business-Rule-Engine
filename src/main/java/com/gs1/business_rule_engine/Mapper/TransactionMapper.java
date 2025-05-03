package com.gs1.business_rule_engine.Mapper;

import com.gs1.business_rule_engine.dto.TransactionDTO;
import com.gs1.business_rule_engine.model.Transaction;

public class TransactionMapper {
    public static TransactionDTO mapToTransactionDTO(Transaction transaction){
        return new TransactionDTO(
                transaction.getId(),
                transaction.getDirection(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getTransactionDate(),
                transaction.getTransactionType(),
                transaction.getStatus()
        );
    }
    public static Transaction mapToTransaction(TransactionDTO transaction){
        return new Transaction(
                transaction.getId(),
                transaction.getDirection(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getTransactionDate(),
                transaction.getTransactionType(),
                transaction.getStatus()
        );
    }
}
