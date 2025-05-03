package com.gs1.business_rule_engine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class BusinessRuleDTO {
    private Long id;
    private String name;
    private String ruleType;
    private String condition ;
    private String action;
    private Integer priority ;
    private Boolean active ;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;

}
