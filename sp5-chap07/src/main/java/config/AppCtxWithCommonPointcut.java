package config;

import aspect2.CacheAspect2;
import aspect2.ExeTimeAspect2;
import chap07.Calculator;
import chap07.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Sang Jun Park on 02/01/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
@EnableAspectJAutoProxy
public class AppCtxWithCommonPointcut {

    @Bean
    public CacheAspect2 cacheAspect(){
        return new CacheAspect2();
    }

    @Bean
    public ExeTimeAspect2 exeTimeAspect(){
        return new ExeTimeAspect2();
    }

    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }
}
