package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.Client;

/**
 * Created by Sang Jun Park on 01/27/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
public class AppCtx {

    @Bean
    public Client client(){
        Client client = new Client();
        client.setHost("host");
        return client;
    }
}
