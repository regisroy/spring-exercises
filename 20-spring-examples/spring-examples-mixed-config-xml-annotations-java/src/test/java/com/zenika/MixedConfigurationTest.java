package com.zenika;

import com.zenika.service.Service;
import com.zenika.spring.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class MixedConfigurationTest {

    public static final String EXPECTED = "pays = France\n" +
            "   region = Ile de France\n" +
            "      departement = Seine - prefecture:Paris\n" +
            "         ville = Paris\n" +
            "      departement = Seine Saint-Denis - prefecture:Saint-Denis\n" +
            "         ville = Bobiny\n" +
            "         ville = Saint-Denis\n" +
            "      departement = Val d'Oise - prefecture:Cergy\n" +
            "         ville = Cergy\n" +
            "      departement = Yvelines - prefecture:Versailles\n" +
            "         ville = Versailles\n" +
            "   region = Rhones-Alpes\n" +
            "      departement = Ain - prefecture:Bourg-en-Bresse\n" +
            "         ville = Bourg-en-Bresse\n" +
            "      departement = Isere - prefecture:Grenoble\n" +
            "         ville = Grenoble\n" +
            "";

    @Test
    @SuppressWarnings("resource")
    public void testJavaAnnotationsXmlConfig() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Service service = applicationContext.getBean("service", Service.class);
        StringBuilder recorder = applicationContext.getBean(StringBuilder.class);

        service.execute();

        assertThat(recorder.toString()).isEqualTo(EXPECTED);
    }

    @Test
    public void testXmlJavaAnnotationsConfig() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Service service = applicationContext.getBean("service", Service.class);
        StringBuilder recorder = applicationContext.getBean(StringBuilder.class);

        service.execute();

        assertThat(recorder.toString()).isEqualTo(EXPECTED);
    }

    @Test
    public void testAnnotationsXmlJavaConfig() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Service service = applicationContext.getBean("service", Service.class);
        StringBuilder recorder = applicationContext.getBean(StringBuilder.class);

        service.execute();

        assertThat(recorder.toString()).isEqualTo(EXPECTED);
    }
}