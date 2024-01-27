package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring2.MemberRegisterService;

/**
 * Created by Sang Jun Park on 01/26/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
public class AppCtxManual2 {

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService();
    }
}
