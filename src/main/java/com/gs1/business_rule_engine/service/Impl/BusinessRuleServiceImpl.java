package com.gs1.business_rule_engine.service.Impl;

import com.gs1.business_rule_engine.Mapper.BusinessRuleMapper;
import com.gs1.business_rule_engine.dto.BusinessRuleDTO;
import com.gs1.business_rule_engine.exception.BadDataException;
import com.gs1.business_rule_engine.exception.NotFoundBusinessRuleException;
import com.gs1.business_rule_engine.exception.ResourceNotFoundException;
import com.gs1.business_rule_engine.model.BusinessRule;
import com.gs1.business_rule_engine.model.RuleType;
import com.gs1.business_rule_engine.repository.BusinessRuleRepository;
import com.gs1.business_rule_engine.service.BusinessRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class BusinessRuleServiceImpl implements BusinessRuleService {
    private final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    BusinessRuleRepository businessRuleRepository;

    @Override
    public List<BusinessRuleDTO> getAllBusinessRules() {
        LOGGER.log(Level.INFO, "getAllBusinessRules method started.");
        List<BusinessRule> businessRules = businessRuleRepository.findAll();

        if(businessRules.isEmpty()){
            throw new NotFoundBusinessRuleException("No Business Rule found in database");
        }
        LOGGER.log(Level.INFO, "getAllBusinessRules method finished.");
        return businessRules.stream().map(BusinessRuleMapper::mapToBusinessRuleDTO).collect(Collectors.toList());
    }

    @Override
    public List<BusinessRuleDTO> findByRuleTypeAndActiveOrderByPriorityDesc(RuleType ruleType) {
        LOGGER.log(Level.INFO, "findByRuleTypeAndActiveOrderByPriorityDesc method started.");
        List<BusinessRule> businessRules = businessRuleRepository.findByRuleTypeAndActiveOrderByPriorityDesc(ruleType,true);

        if(businessRules.isEmpty()){
            throw new NotFoundBusinessRuleException("No Business Rule found in database");
        }
        LOGGER.log(Level.INFO, "findByRuleTypeAndActiveOrderByPriorityDesc method finished.");
        return businessRules.stream().map(BusinessRuleMapper::mapToBusinessRuleDTO).collect(Collectors.toList());
    }

    @Override
    public BusinessRuleDTO getBusinessRuleById(Long id) {
        LOGGER.log(Level.INFO, "getBusinessRuleById method started. task id : " + id);

        BusinessRule businessRule = businessRuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BusinessRule is not exist with given id : " + id));

        LOGGER.log(Level.INFO, "getBusinessRuleById method finished. task id : " + id);
        return BusinessRuleMapper.mapToBusinessRuleDTO(businessRule);
    }

    @Override
    public BusinessRuleDTO createTaskBusinessRule(BusinessRuleDTO businessRuleDTO) {
        LOGGER.log(Level.INFO, "createTaskBusinessRule method started.");
        BusinessRule businessRule = BusinessRuleMapper.mapToBusinessRule(businessRuleDTO);
        businessRule = businessRuleRepository.save(businessRule);
        LOGGER.log(Level.INFO, "createTaskBusinessRule method finished. BusinessRule id : %d".formatted(businessRule.getId()));
        return BusinessRuleMapper.mapToBusinessRuleDTO(businessRule);
    }

    @Override
    public BusinessRuleDTO updateBusinessRule(Long id, BusinessRuleDTO businessRuleDetails) {
        BusinessRuleDTO businessRuleDto = getBusinessRuleById(id);
        LOGGER.log(Level.INFO, "updateBusinessRule method started. BusinessRule id : %d".formatted(id));

        businessRuleDto.setName(businessRuleDetails.getName() != null ? businessRuleDetails.getName() : businessRuleDto.getName());
        businessRuleDto.setRuleType(businessRuleDetails.getRuleType() != null ? businessRuleDetails.getRuleType() : businessRuleDto.getRuleType());
        businessRuleDto.setCondition(businessRuleDetails.getCondition() != null ? businessRuleDetails.getCondition() : businessRuleDto.getCondition());
        businessRuleDto.setAction(businessRuleDetails.getAction() != null ? businessRuleDetails.getAction() : businessRuleDto.getAction());
        businessRuleDto.setPriority(businessRuleDetails.getPriority() != null ? businessRuleDetails.getPriority() : businessRuleDto.getPriority());
        businessRuleDto.setActive(businessRuleDetails.getActive() != null ? businessRuleDetails.getActive() : businessRuleDto.getActive());

        BusinessRule businessRule = BusinessRuleMapper.mapToBusinessRule(businessRuleDto);
        businessRule =  businessRuleRepository.save(businessRule);
        LOGGER.log(Level.INFO, "updateBusinessRule method finished. BusinessRule id : %d".formatted(id));
        return BusinessRuleMapper.mapToBusinessRuleDTO(businessRule);
    }

    @Override
    public BusinessRuleDTO updateBusinessRuleStatus(Long id, Boolean newStatus) {
        BusinessRuleDTO businessRuleDto = getBusinessRuleById(id);
        LOGGER.log(Level.INFO, "updateBusinessRuleStatus method started. BusinessRule id : %d".formatted(id));
        if(newStatus == null)
            throw new BadDataException("newStatus is null");

        businessRuleDto.setActive(newStatus);
        BusinessRule businessRule = BusinessRuleMapper.mapToBusinessRule(businessRuleDto);
        businessRule =  businessRuleRepository.save(businessRule);
        LOGGER.log(Level.INFO, "updateBusinessRuleStatus method finished. BusinessRule id : %d".formatted(id));
        return BusinessRuleMapper.mapToBusinessRuleDTO(businessRule);
    }

    @Override
    public void deleteBusinessRule(Long id) {
        LOGGER.log(Level.INFO, "deleteBusinessRule method started. BusinessRule id : %d".formatted( id));
        BusinessRuleDTO businessRuleDTO = getBusinessRuleById(id);
        businessRuleRepository.deleteById(businessRuleDTO.getId());
        LOGGER.log(Level.INFO, "deleteBusinessRule method finished. BusinessRule id : %d".formatted( id));
    }
}
