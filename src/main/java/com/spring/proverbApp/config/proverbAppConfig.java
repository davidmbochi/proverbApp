package com.spring.proverbApp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.proverbApp.Dao.proverbAppDao;
import com.spring.proverbApp.service.proverbAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.spring.proverbApp")
@PropertySource("classpath:persistence-postgre.properties")
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
    public proverbAppService proverbAppService(){
        return proverbAppService();
    }

    @Bean
    public proverbAppDao proverbAppDao(){
        return proverbAppDao();
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


        return comboPooledDataSource;
    }

}
