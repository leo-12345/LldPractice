package com.LowLevelDesign.config;

import com.LowLevelDesign.Constant;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactorySlave",
  transactionManagerRef = "transactionManagerSlave",
  basePackages = {
    "com.LowLevelDesign.db.repository.slave"
  })
public class DataSourceConfigurationSlave {
  private static final String SLAVE_PREFIX = "spring.db.slave";

  @Bean
  @ConfigurationProperties(SLAVE_PREFIX)
  public DataSourceProperties slaveDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  @Qualifier("slaveDataSource")
  @ConfigurationProperties(SLAVE_PREFIX)
  public DataSource slaveDataSource() {
    return slaveDataSourceProperties()
      .initializeDataSourceBuilder()
      .type(HikariDataSource.class)
      .build();
  }

  @Bean(name = "entityManagerFactorySlave")
  public LocalContainerEntityManagerFactoryBean slaveEntityManagerFactory(
    EntityManagerFactoryBuilder builder) {
    return builder
      .dataSource(slaveDataSource())
      .packages(Constant.ENTITY_BASE_PKG, Constant.DYNAMIC_CONFIG_BASE_PKG)
      .build();
  }

  @Bean(name = "transactionManagerSlave")
  public PlatformTransactionManager transactionManager(
    @Qualifier("entityManagerFactorySlave") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
