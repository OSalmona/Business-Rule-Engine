package com.gs1.business_rule_engine.Mapper;

import com.gs1.business_rule_engine.dto.BusinessRuleDTO;
import com.gs1.business_rule_engine.model.BusinessRule;
import com.gs1.business_rule_engine.model.RuleType;

public class BusinessRuleMapper {
    public static BusinessRuleDTO mapToBusinessRuleDTO(BusinessRule businessRule){
        return new BusinessRuleDTO(
                businessRule.getId(),
                businessRule.getName(),
                businessRule.getRuleType().name(),
                businessRule.getCondition(),
                businessRule.getAction(),
                businessRule.getPriority(),
                businessRule.getActive(),
                businessRule.getCreatedAt(),
                businessRule.getCreatedBy(),
                businessRule.getUpdatedAt(),
                businessRule.getUpdatedBy()
        );
    }
    public static BusinessRule mapToBusinessRule(BusinessRuleDTO businessRule){
        return new BusinessRule(
                businessRule.getId(),
                businessRule.getName(),
                RuleType.valueOf(businessRule.getRuleType()),
                businessRule.getCondition(),
                businessRule.getAction(),
                businessRule.getPriority(),
                businessRule.getActive(),
                businessRule.getCreatedAt(),
                businessRule.getCreatedBy(),
                businessRule.getUpdatedAt(),
                businessRule.getUpdatedBy()
        );
    }
}
