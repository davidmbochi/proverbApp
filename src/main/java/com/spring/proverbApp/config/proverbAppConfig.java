package com.spring.proverbApp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.proverbApp.Dao.proverbAppDao;
import com.spring.proverbApp.service.proverbAppService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.spring.proverbApp")
@PropertySource(value = "classpath:persistence-postgresql.properties")
public class proverbAppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource proverbAppDataSource(){
        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        comboPooledDataSource.setUser(environment.getProperty("jdbc.user"));
        comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));

        comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        comboPooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        comboPooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        comboPooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));


        return comboPooledDataSource;
    }

    private int getIntProperty(String propName){
        int intPropVal= Integer.parseInt((propName));

        return intPropVal;
    }

    private Properties getHibernateProperties(){
        Properties properties =new Properties();

        properties.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));

        properties.setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));

        return properties;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(){
        LocalSessionFactoryBean sessionFactory= new LocalSessionFactoryBean();
        sessionFactory.setDataSource(proverbAppDataSource());
        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packageToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hibernateTransactionManager= new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

}
