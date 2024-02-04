package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.tomcat.jdbc.pool.DataSource;
import spring.MemberDao;

/**
 * Created by Sang Jun Park on 02/02/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
public class AppCtx {

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
        ds.setUsername("spring5");
        ds.setPassword("spring5");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        return ds;
    }

    @Bean
    public MemberDao memberDao(){
        return new MemberDao(dataSource());
    }
}
