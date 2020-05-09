package com.newbiest.common.idgenerator.repository;

import com.newbiest.base.exception.ClientException;
import com.newbiest.base.repository.custom.IRepository;
import com.newbiest.common.idgenerator.model.GeneratorRuleLine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by guoxunbo on 2018/8/7.
 */
@Repository
public interface GeneratorRuleLineRepository extends IRepository<GeneratorRuleLine, String> {

    @Modifying
    @Query("DELETE FROM GeneratorRuleLine WHERE ruleRrn = :ruleRrn")
    void deleteByRuleRrn(@Param("ruleRrn") String ruleRrn) throws ClientException;

}
