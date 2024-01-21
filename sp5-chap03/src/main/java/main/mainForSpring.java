package main;

import config.AppCtx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/**
 * Created by Sang Jun Park on 01/20/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class mainForSpring {
    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
        Member member1 = new Member("aaa@gmail.com", "aaa", "aaa", LocalDateTime.now());
        Member member2 = new Member("bbb@gmail.com", "bbb", "bbb", LocalDateTime.now());
        memberDao.insert(member1);
        memberDao.insert(member2);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        printHelp();
        while(true){
            System.out.println("Please enter a command.");
            String command = reader.readLine();

            if(command.equals("exit")){
                System.out.println("Exit program.");
                break;
            } else if(command.startsWith("new")){
                processNewCommand(command.split(" "));
                continue;
            } else if(command.startsWith("change ")){
                processChangeCommand(command.split(" "));
                continue;
            } else if(command.equals("list")){
                processListCommand();
                continue;
            } else if(command.startsWith("info ")){
                processInfoCommand(command.split(" "));
                continue;
            } else if(command.equals("version")){
                processVersionCommand();
                continue;
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] args){
        if(args.length != 5){
            printHelp();
        }

        MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(args[1]);
        req.setName(args[2]);
        req.setPassword(args[3]);
        req.setConfirmPassword(args[4]);

        if(!req.isPasswordEqualToConfirmPassword()){
            System.out.println("Password is not matched.\n");
            return;
        }

        try{
            regSvc.register(req);
            System.out.println("Registered.\n");
        } catch (DuplicateMemberException e){
            System.out.println("Already exist email.\n");
        }
    }

    private static void processChangeCommand(String[] args){
        if(args.length != 4){
            printHelp();
            return;
        }

        ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            changePwdSvc.changePassword(args[1], args[2], args[3]);
            System.out.println("Password is changed.\n");
        } catch (MemberNotFoundException e){
            System.out.println("Email doesn't exist.\n");
        } catch (WrongIdPasswordException e){
            System.out.println("Email and password are not matched.\n");
        }
    }

    private static void printHelp(){
        System.out.println();
        System.out.println("<<<<<<<<<<<<             Command             >>>>>>>>>>>>");
        System.out.println("Register        : new email name password confirmPassword");
        System.out.println("Change Password : change email currentPassword newPassword");
        System.out.println();
    }

    private static void processListCommand(){
        MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }

    private static void processInfoCommand(String[] args){
        if(args.length != 2){
            printHelp();
            return;
        }
        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(args[1]);
    }

    private static void processVersionCommand(){
        VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }
}
