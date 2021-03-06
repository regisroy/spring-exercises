package com.zenika.spring;

import com.zenika.service.Service;
import com.zenika.service.ServiceImplOneConfigJava;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.zenika")
@ImportResource("classpath:com/zenika/spring/application-context.xml")
public class AppConfigWithJavaAndImportXmlAndComponentScan {

    @Bean(name="service")
    public Service serviceOne() {
        return new ServiceImplOneConfigJava(recorder());
    }

    @Bean
    public StringBuilder recorder() {
        return new StringBuilder();
    }

}
