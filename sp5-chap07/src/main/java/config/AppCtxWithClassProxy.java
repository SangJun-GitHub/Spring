package config;

import aspect.ExeTimeAspect;
import chap07.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Sang Jun Park on 02/01/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtxWithClassProxy {
    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }

    @Bean
    public RecCalculator calculator() {
        return new RecCalculator();
    }

}