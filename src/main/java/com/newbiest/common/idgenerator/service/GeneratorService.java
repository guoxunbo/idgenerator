package com.newbiest.common.idgenerator.service;

import com.newbiest.base.exception.ClientException;
import com.newbiest.common.idgenerator.model.GeneratorRule;
import com.newbiest.common.idgenerator.utils.GeneratorContext;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by guoxunbo on 2018/8/6.
 */
public interface GeneratorService {

    void deleteGeneratorRule(String ruleRrn) throws ClientException;

    String generatorId(GeneratorContext context) throws ClientException;
    List<String> generatorId(@NotNull GeneratorRule rule, GeneratorContext context) throws ClientException;
    List<String> generatorId(@NotNull GeneratorRule rule, boolean isParameterList, GeneratorContext context) throws ClientException;

    List<Integer> getNextSequenceValue(String generateRrn, String sequenceName, int count) throws ClientException;;
    List<Integer> getNextSequenceValue(String generateRrn, String sequenceName, int count, int minValue) throws ClientException;
    List<Integer> getNextSequenceValue(String generateRrn, String sequenceName, int count, int minValue, boolean newTrans) throws ClientException;


}
