package com.gs1.business_rule_engine.service;

import com.gs1.business_rule_engine.dto.BusinessRuleDTO;
import com.gs1.business_rule_engine.model.RuleType;
import java.util.List;


public interface BusinessRuleService {
    public List<BusinessRuleDTO> getAllBusinessRules();
    public List<BusinessRuleDTO> findByRuleTypeAndActiveOrderByPriorityDesc(RuleType ruleType);
    public BusinessRuleDTO getBusinessRuleById(Long id);
    public BusinessRuleDTO createTaskBusinessRule(BusinessRuleDTO businessRuleDTO);
    public BusinessRuleDTO updateBusinessRule(Long id, BusinessRuleDTO businessRuleDTO);
    public BusinessRuleDTO updateBusinessRuleStatus(Long id, Boolean newStatus);
    public void deleteBusinessRule(Long id);
}
