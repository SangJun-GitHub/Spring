package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ChangePasswordService;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

/**
 * Created by Sang Jun Park on 02/12/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainForCPS {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            cps.changePassword("abc@abc.com", "1234", "1111");
            System.out.println("The password is changed Successfully.");
        } catch (MemberNotFoundException e) {
            System.out.println("The member is not exist.");
        } catch (WrongIdPasswordException e) {
            System.out.println("The password is incorrect.");
        }

        ctx.close();

    }
}