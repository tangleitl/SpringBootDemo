package demo.conf;

import demo.bean.DemoBean;
import demo.listener.DemoPublisher;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("demo.listener")
public class DemoConfiuration {

    @Bean
    @Profile("dev")
    public DemoBean getDevDemoBean(){
        DemoBean demoBean = new DemoBean();
        demoBean.setValue5("dev");
        return demoBean;
    }

    @Bean
    @Profile("product")
    public DemoBean getProductDemoBean(){
        DemoBean demoBean = new DemoBean();
        demoBean.setValue5("product");
        return demoBean;
    }

    public static void testConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        DemoBean bean = context.getBean(DemoBean.class);
        DemoBean demoBean;
        //配置active标示之前不能注册配置类的class,否则自动就对配置类中的相关bean进行初始化了。而没有按照指定的active进行初始化。
        context.getEnvironment().setActiveProfiles("dev");
        context.register(DemoConfiuration.class);
        //register之后必须进行refresh
        context.refresh();
        demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getValue5());
        context.close();
    }

    public static void testEvent(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DemoConfiuration.class);
        context.refresh();
        DemoPublisher publisher = context.getBean(DemoPublisher.class);
        publisher.publish("hello");
    }
    public static void main(String[] args) {
        testEvent();
    }
}
