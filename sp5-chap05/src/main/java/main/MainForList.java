package main;

import config.AppCtxForList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Sang Jun Park on 01/26/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainForList {

    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(AppCtxForList.class);

        String[] names = ctx.getBeanDefinitionNames();
        Arrays.stream(names).forEach(name -> System.out.println(name));
    }

}