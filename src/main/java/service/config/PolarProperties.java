package service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "polar")
public class PolarProperties {

//    this annotation makes sure that the applivation is listening for the Actuator refresh endpoint
//    each time a refresh event is triggered, this class will reaload the latest configuration variable.

    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
