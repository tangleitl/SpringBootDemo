package demo.listener;

import demo.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {
    @Autowired
    private ApplicationContext context;
    public void publish(String msg){
        DemoEvent event = new DemoEvent(this,msg);
        context.publishEvent(event);
    }
}
