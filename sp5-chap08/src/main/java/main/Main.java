package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sang Jun Park on 02/15/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class Main {
    private static AnnotationConfigApplicationContext ctx= null;
    public static void main(String[] args) throws IOException {

        ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            System.out.println("Please enter a command.");
            String command = reader.readLine();

            if(command.equals("exit")){
                System.out.println("Exit program.");
                break;
            }

            if(command.startsWith("new ")){
                processNewCommand(command.split(" "));
            } else if(command.startsWith("change ")){
                processChangeCommand(command.split(" "));
            } else if(command.equals("list")){
                processListCommand();
            } else if(command.startsWith("info ")){
                processInfoCommand(command.split(" "));
            } else {
                printHelp();
            }
        }

        ctx.close();
    }

    public static void processNewCommand(String[] arg){

        if(arg.length != 5){
            printHelp();
            return;
        }

        MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

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
    public static void processChangeCommand(String[] arg){

        if(arg.length != 4){
            printHelp();
            return;
        }

        ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("The password is changed Successfully.");
        } catch (MemberNotFoundException e) {
            System.out.println("The member is not exist.");
        } catch (WrongIdPasswordException e) {
            System.out.println("The password is incorrect.");
        }
    }
    public static void processListCommand(){

        MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }
    public static void processInfoCommand(String[] arg){

        if(arg.length != 2){
            printHelp();
            return;
        }

        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(arg[1]);
    }
    public static void printHelp(){
        System.out.println();
        System.out.println("Invalid Command. Check commands below");
        System.out.println("----------------     Command List     ----------------");
        System.out.println("new [email] [name] [password] [confirm password]");
        System.out.println("    Register new member - ex)new abc@abc.com 1234 1234\n");
        System.out.println("change [emil] [current password] [new password]");
        System.out.println("    Change password - ex)change abc@abc.com 1234 1111\n");
        System.out.println("info [email] ex)info");
        System.out.println("    Display a member information - ex)info abc@abc.com\n");
        System.out.println("list");
        System.out.println("    Display all members information\n");
    }
}
