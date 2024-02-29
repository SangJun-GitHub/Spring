package config;

import chap10.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sang Jun Park on 03/01/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
public class ControllerConfig {

    @Bean
    public HelloController helloController(){
        return new HelloController();
    }
}
