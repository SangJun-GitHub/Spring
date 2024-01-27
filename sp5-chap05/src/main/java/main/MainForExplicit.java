package main;

import config.AppCtxWithExplicit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

/**
 * Created by Sang Jun Park on 01/26/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainForExplicit {
    private static AbstractApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(
                AppCtxWithExplicit.class);

        ctx.close();
    }
}
