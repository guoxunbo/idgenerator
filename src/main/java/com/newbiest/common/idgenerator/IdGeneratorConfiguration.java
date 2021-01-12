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
    
}
