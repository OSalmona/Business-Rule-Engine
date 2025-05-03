package com.gs1.business_rule_engine.model;

import com.gs1.business_rule_engine.dto.TransactionDTO;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class RuleExecutionResult {
    private TransactionDTO transactionDTO;
    private List<String> appliedRules = new ArrayList<>();

    public RuleExecutionResult(TransactionDTO transactionDTO) {
        this.transactionDTO = transactionDTO;
    }
    public int getAppliedRulesCount() {
        return appliedRules.size();
    }
}