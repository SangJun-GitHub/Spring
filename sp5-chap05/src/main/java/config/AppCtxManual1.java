package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * Created by Sang Jun Park on 01/26/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
public class AppCtxManual1 {

    //Manual injection is priority than auto-injection
    //So there is only exist manual-injected bean in container
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService();
    }
}
