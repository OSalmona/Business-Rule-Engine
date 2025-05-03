package com.gs1.business_rule_engine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RuleType ruleType;
    @Column(nullable = false)
    private String condition ;
    @Column(nullable = false)
    private String action;
    @Column(nullable = false)
    private Integer priority ;
    @Column(nullable = false)
    private Boolean active = true;
    @Column()
    private LocalDateTime createdAt;
    @Column()
    private Long createdBy;
    @Column()
    private LocalDateTime updatedAt;
    @Column()
    private Long updatedBy;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PostUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
