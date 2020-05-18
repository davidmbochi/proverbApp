package com.spring.proverbApp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.spring.proverbApp")
@PropertySource( "classpath:security-persistence-postgresql.properties")
public class ProverbAppConfigSecurityDataSource implements WebMvcConfigurer {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource securityDataSource(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(environment.getProperty("security.jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl(environment.getProperty("security.jdbc.url"));
        comboPooledDataSource.setUser(environment.getProperty("security.jdbc.user"));
        comboPooledDataSource.setPassword(environment.getProperty("security.jdbc.password"));

        comboPooledDataSource.setInitialPoolSize(getIntProperty("security.connection.pool.initialPoolSize"));
        comboPooledDataSource.setMinPoolSize(getIntProperty("security.connection.pool.minPoolSize"));
        comboPooledDataSource.setMaxPoolSize(getIntProperty("security.connection.pool.maxPoolSize"));
        comboPooledDataSource.setMaxIdleTime(getIntProperty("security.connection.pool.maxIdleTime"));

        return comboPooledDataSource;
    }

    private int getIntProperty(String propName){
        String propVal = environment.getProperty(propName);

        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }

    private Properties getHibernateProperties(){
        Properties properties =new Properties();

        properties.setProperty("hibernate.dialect",environment.getProperty("security.hibernate.dialect"));

        properties.setProperty("hibernate.show_sql",environment.getProperty("security.hibernate.show_sql"));

        return properties;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBeanSecurity(){
        LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
        sessionFactory.setDataSource(securityDataSource());
        sessionFactory.setPackagesToScan(environment.getProperty("security.hibernate.packageToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    @Qualifier("localSessionFactoryBeanSecurity")
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hibernateTransactionManager= new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

}
