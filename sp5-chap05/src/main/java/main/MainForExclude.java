package main;

import config.AppCtxWithExclude;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by Sang Jun Park on 01/26/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainForExclude {

    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(AppCtxWithExclude.class);

    }

}
