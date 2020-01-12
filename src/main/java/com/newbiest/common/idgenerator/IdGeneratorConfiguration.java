package com.newbiest.common.idgenerator;

import com.newbiest.base.factory.ModelFactory;
import com.newbiest.common.idgenerator.model.*;
import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by guoxunbo on 2019/1/10.
 */
@Slf4j
@Component
public class IdGeneratorConfiguration {

    @Bean("idGeneratorLiquibase")
    public SpringLiquibase liquibase(DataSource dataSource) throws Exception{
        if (log.isInfoEnabled()) {
            log.info("Load IDGenerator Liquibase Configuration.");
        }
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-idgenerator.yaml");
        liquibase.setShouldRun(true);
        liquibase.setDropFirst(false);
        return liquibase;
    }

    @PostConstruct
    public void init() {
        //注册modelClassLoader
        ModelFactory.registerModelClassLoader(GeneratorRule.class.getName(), GeneratorRule.class.getClassLoader());
        ModelFactory.registerModelClassLoader(GeneratorRuleLine.class.getName(), GeneratorRuleLine.class.getClassLoader());
        ModelFactory.registerModelClassLoader(Sequence.class.getName(), Sequence.class.getClassLoader());

        ModelFactory.registerModelClassLoader(FixedStringRuleLine.class.getName(), FixedStringRuleLine.class.getClassLoader());
        ModelFactory.registerModelClassLoader(DateRuleLine.class.getName(), DateRuleLine.class.getClassLoader());
        ModelFactory.registerModelClassLoader(SequenceRuleLine.class.getName(), SequenceRuleLine.class.getClassLoader());
        ModelFactory.registerModelClassLoader(VariableRuleLine.class.getName(), VariableRuleLine.class.getClassLoader());

    }
}
