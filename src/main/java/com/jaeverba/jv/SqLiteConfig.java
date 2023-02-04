package com.jaeverba.jv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "basicDBEntityManagerFactory",
        transactionManagerRef = "basicDBTransactionManager",
        basePackages = {"com.jaeverba.jv.model.SqLite.repository"}
)
public class SqLiteConfig {
    @Autowired
    private Environment env;

    @Bean(name = "basicDBDataSource")
    public DataSource basicDBDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(env.getProperty("sqlite.datasource.url"));
        dataSource.setUsername(env.getProperty("sqlite.datasource.username"));
        dataSource.setPassword(env.getProperty("sqlite.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("sqlite.datasource.driver-class-name"));

        return dataSource;
    }

    @Bean(name = "basicDBEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(basicDBDataSource());
        em.setPackagesToScan(("com.jaeverba.jv.model.SqLite.entity"));

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("sqlite.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("sqlite.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("sqlite.jpa.database-platform"));

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "basicDBTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
