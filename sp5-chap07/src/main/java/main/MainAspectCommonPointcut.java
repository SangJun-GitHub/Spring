package main;

import chap07.Calculator;
import config.AppCtxWithCommonPointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Sang Jun Park on 02/01/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainAspectCommonPointcut {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithCommonPointcut.class);

        Calculator cal = ctx.getBean("calculator", Calculator.class);
        cal.factorial(7);
        cal.factorial(7);
        cal.factorial(5);
        cal.factorial(5);
        ctx.close();
    }
}
