package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.MemberDao;
import spring.MemberPrinter;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

/**
 * Created by Sang Jun Park on 01/26/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
//@ComponentScan(basePackages = {"spring"}, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))
//@ComponentScan(basePackages = {"spring"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "spring.*Dao"))
//@ComponentScan(basePackages = {"spring", "spring2"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {NoProduct.class, ManualBean.class}))
//@ComponentScan(basePackages = {"spring"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class))
//@ComponentScan(basePackages = {"spring"}, excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class),
//        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "spring2\\..*")
//})
@ComponentScan(basePackages = {"spring", "spring2" }, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = NoProduct.class )})
public class AppCtxWithExclude {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
