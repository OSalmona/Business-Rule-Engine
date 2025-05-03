package com.gs1.business_rule_engine.service;

import com.gs1.business_rule_engine.dto.TransactionDTO;

public interface BusinessRuleEngineService {
    public boolean evaluateCondition(String condition, TransactionDTO transaction);
    public void executeAction(String action, TransactionDTO transaction);
}

