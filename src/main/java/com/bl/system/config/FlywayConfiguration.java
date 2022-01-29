package com.bl.system.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {

    /**
     * @param dataSource dataSource
     */
    @Autowired
    public FlywayConfiguration(final DataSource dataSource) {
        //Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().repair();
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }
}
