package config;

import aspect.ExeTimeAspect;
import chap07.Calculator;
import chap07.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Sang Jun Park on 01/30/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {

    @Bean
    public ExeTimeAspect exeTimeAspect(){
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }
}
