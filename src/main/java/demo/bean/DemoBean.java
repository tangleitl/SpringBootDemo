package demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
@PropertySource("classpath:application.properties")
public class DemoBean {
    @Value("${demo.value1}")
    private String value1;
    @Value("${demo.value2}")
    private String value2;
    @Value("123")
    private String value3;
    @Value("#{systemProperties['os.name']}")
    private String value4;
    private String value5;

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void distory(){
        System.out.println("destory");
    }
    @Override
    public String toString() {
        return "DemoBean{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + "\'" +
                '}';
    }

}
