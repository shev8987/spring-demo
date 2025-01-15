/*
package com.shev8987.spring.demo.config;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.shev8987.spring.demo.service.hibernate")
@EnableTransactionManagement
public class HibernateConfig {

    private static final Logger logger = LoggerFactory.getLogger(HibernateConfig.class);

    private static String database;
    private static String dataBasePlatform;
    private static String databaseDriver;

    private static String url;
    private static String userName;
    private static String password;

    @Value("${spring.jpa.database}")
    public void setDatabase(String database) {
        HibernateConfig.database = database;
    }

    @Value("${spring.jpa.database-platform}")
    public void setDataBasePlatform(String dataBasePlatform) {
        HibernateConfig.dataBasePlatform = dataBasePlatform;
    }

    @Value("${spring.datasource.driver-class-name}")
    public void setClickhousePassword(String databaseDriver) {
        HibernateConfig.databaseDriver = databaseDriver;
    }

    @Value("${spring.datasource.url}")
    public void setDatabaseUrl(String url) {
        HibernateConfig.url = url;
    }

    @Value("${spring.datasource.username}")
    public void setDataBaseUserName(String userName) {
        HibernateConfig.userName = userName;
    }

    @Value("${spring.datasource.password}")
    public void setDataBasePassword(String password) {
        HibernateConfig.password = password;
    }


    @Bean
    public DataSource dataSource() {

        try {

            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.HSQL)
        } catch (Exception ex) {
            logger.error("Embedded DataSource beasn cannot be created: " + ex);
            return null;
        }
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.shev8987.spring.demo.service.hibernate");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    private Properties hibernateProperties(){

    }

    @Bean
    PlatformTransactionManager transactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }
}
*/
