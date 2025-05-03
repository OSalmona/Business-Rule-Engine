package com.gs1.business_rule_engine.service.Impl;

import com.gs1.business_rule_engine.dto.BusinessRuleDTO;
import com.gs1.business_rule_engine.dto.TransactionDTO;
import com.gs1.business_rule_engine.model.RuleExecutionResult;
import com.gs1.business_rule_engine.model.RuleType;
import com.gs1.business_rule_engine.repository.BusinessRuleRepository;
import com.gs1.business_rule_engine.service.BusinessRuleEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessRuleEngineServiceImpl implements BusinessRuleEngineService {
    @Autowired
    private BusinessRuleRepository businessRuleRepository;
    @Autowired
    private BusinessRuleServiceImpl businessRuleService;

    private final ExpressionParser parser = new SpelExpressionParser();

    @Override
    public boolean evaluateCondition(String condition, TransactionDTO transaction) {
        try {
            StandardEvaluationContext context = new StandardEvaluationContext(transaction);
            Expression exp = parser.parseExpression(condition);
            return Boolean.TRUE.equals(exp.getValue(context, Boolean.class));
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating condition: " + condition, e);
        }
    }

    @Override
    public void executeAction(String action, TransactionDTO transaction) {
        try {
            StandardEvaluationContext context = new StandardEvaluationContext(transaction);
            Expression exp = parser.parseExpression(action);
            exp.getValue(context);
        } catch (Exception e) {
            throw new RuntimeException("Error executing action: " + action, e);
        }
    }

    public RuleExecutionResult processTransaction(TransactionDTO transaction){
        RuleExecutionResult result = new RuleExecutionResult(transaction);

        List<BusinessRuleDTO> enrichmentRules = businessRuleService
                .findByRuleTypeAndActiveOrderByPriorityDesc(RuleType.Enrichment);

        for (BusinessRuleDTO rule : enrichmentRules) {
            if (evaluateCondition(rule.getCondition(), transaction)) {
                executeAction(rule.getAction(), transaction);
                result.getAppliedRules().add(rule.getName());
            }
        }

        List<BusinessRuleDTO> routingRules = businessRuleService
                .findByRuleTypeAndActiveOrderByPriorityDesc(RuleType.Routing);

        for (BusinessRuleDTO rule : routingRules) {
            if (evaluateCondition(rule.getCondition(), transaction)) {
                executeAction(rule.getAction(), transaction);
                result.getAppliedRules().add(rule.getName());
                break;
            }
        }
        return result;
    }

}
