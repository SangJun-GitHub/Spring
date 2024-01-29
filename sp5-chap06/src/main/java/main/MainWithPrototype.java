package main;

import config.AppCtxWithPrototype;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import spring.Client;
import spring.Client2;

/**
 * Created by Sang Jun Park on 01/28/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainWithPrototype {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtxWithPrototype.class);

        Client client1_1 = ctx.getBean(Client.class);
        Client client1_2 = ctx.getBean(Client.class);

        Client2 client2_1 = ctx.getBean(Client2.class);
        Client2 client2_2 = ctx.getBean(Client2.class);

        client1_1.send();
        client1_2.send();
        client2_1.send();
        client2_2.send();

        System.out.println("client1_1 == client1_2 : " + (client1_1 == client1_2));
        System.out.println("client2_1 == client2_2 : " + (client2_1 == client2_2));

        ctx.close();
    }
}
