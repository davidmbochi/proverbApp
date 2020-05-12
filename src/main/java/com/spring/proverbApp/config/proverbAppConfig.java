package com.spring.proverbApp.config;

import com.spring.proverbApp.Dao.proverbAppDao;
import com.spring.proverbApp.service.proverbAppService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.spring.proverbApp")
@PropertySource("classpath:persistence-postgre.properties")
public class proverbAppConfig {

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
}
