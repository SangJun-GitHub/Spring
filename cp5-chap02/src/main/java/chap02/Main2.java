package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Sang Jun Park on 6/15/2023.
 * Github : http://github.com/SangJun-GitHub
 */
public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        Greeter g2 = ctx.getBean("greeter", Greeter.class);

        System.out.println("g1 == g2 : " + (g1 == g2));
        ctx.close();
    }
}
