package main;

import chap07.Calculator;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Sang Jun Park on 01/30/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean("calculator", Calculator.class);
        long fiveFact = cal.factorial(5);
        System.out.println("cal.factorial(5) = " + fiveFact);
        System.out.println(cal.getClass().getName());

        ctx.close();
    }
}
