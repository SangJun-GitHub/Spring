package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sang Jun Park on 6/15/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@Configuration
public class AppContext {
    @Bean
    public Greeter greeter(){
        Greeter g = new Greeter();
        g.setFormat("%s, Hello!");
        return g;
    }
}
