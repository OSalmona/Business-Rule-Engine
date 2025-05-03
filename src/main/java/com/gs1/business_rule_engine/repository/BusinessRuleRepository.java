package com.gs1.business_rule_engine.repository;

import com.gs1.business_rule_engine.model.BusinessRule;
import com.gs1.business_rule_engine.model.RuleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRuleRepository extends JpaRepository<BusinessRule,Long> {
    List<BusinessRule> findByRuleTypeAndActiveOrderByPriorityDesc(RuleType ruleType, boolean active);

}
