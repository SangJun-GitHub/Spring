package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberDao;
import spring.MemberPrinter;

/**
 * Created by Sang Jun Park on 01/21/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
public class AppConf1 {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
}
