package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.Client;
import spring.Client2;

/**
 * Created by Sang Jun Park on 01/28/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
public class AppCtxWithPrototype {

    @Bean(initMethod = "connect", destroyMethod = "close")
    public Client2 client2(){
        Client2 client = new Client2();
        client.setHost("host");
        return client;
    }


    @Bean
    @Scope("prototype")
    public Client client() {
        Client client = new Client();
        client.setHost("host");
        return client;
    }
}
