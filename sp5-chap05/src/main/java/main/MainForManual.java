package main;

import config.AppCtxManual1;
import config.AppCtxManual2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

/**
 * Created by Sang Jun Park on 01/26/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainForManual {
    private static AbstractApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(
                AppCtxManual1.class, AppCtxManual2.class);

        ctx.close();
    }
}
