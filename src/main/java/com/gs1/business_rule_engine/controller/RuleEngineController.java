package com.gs1.business_rule_engine.controller;

import com.gs1.business_rule_engine.dto.BusinessRuleDTO;
import com.gs1.business_rule_engine.dto.TransactionDTO;
import com.gs1.business_rule_engine.model.RuleExecutionResult;
import com.gs1.business_rule_engine.service.BusinessRuleService;
import com.gs1.business_rule_engine.service.Impl.BusinessRuleEngineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/rules")
public class RuleEngineController {
    @Autowired
    private BusinessRuleService businessRuleService;
    @Autowired
    private BusinessRuleEngineServiceImpl ruleEngineService;

    @PostMapping
    public ResponseEntity<BusinessRuleDTO> createRule(@Validated @RequestBody BusinessRuleDTO rule) {
        BusinessRuleDTO savedBusinessRule = businessRuleService.createTaskBusinessRule(rule);
        return new ResponseEntity<>(savedBusinessRule , HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BusinessRuleDTO> updateRule(@PathVariable Long id, @Validated @RequestBody BusinessRuleDTO rule) {
        BusinessRuleDTO savedBusinessRule = businessRuleService.updateBusinessRule(id,rule);
        return new ResponseEntity<>(savedBusinessRule , HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long id) {
        businessRuleService.deleteBusinessRule(id);
        return ResponseEntity.ok("BusinessRule deleted successfully");
    }
    @GetMapping
    public ResponseEntity<List<BusinessRuleDTO>> listRules() {
        List<BusinessRuleDTO> businessRuleDTOS = businessRuleService.getAllBusinessRules();
        return new ResponseEntity<>(businessRuleDTOS ,HttpStatus.OK );
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusinessRuleDTO> getRule(@PathVariable Long id) {
        BusinessRuleDTO businessRuleDTO = businessRuleService.getBusinessRuleById(id);

        return new ResponseEntity<>(businessRuleDTO ,HttpStatus.OK );
    }
    @PostMapping("/process")
    public ResponseEntity<RuleExecutionResult> processTransaction(
            @RequestBody TransactionDTO transaction) {
        return ResponseEntity.ok(ruleEngineService.processTransaction(transaction));
    }
}
