package main;

import assembler.Assembler;
import spring.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sang Jun Park on 01/19/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainForAssembler {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        printHelp();
        while(true){
            System.out.println("Please enter a command.");
            String command = reader.readLine();

            if(command.equals("exit")){
                System.out.println("Exit program.");
                break;
            }

            if(command.startsWith("new")){
                processNewCommand(command.split(" "));
                continue;
            } else if(command.startsWith("change ")){
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static Assembler assembler = new Assembler();

    private static void processNewCommand(String[] args){
        if(args.length != 5){
            printHelp();
        }

        MemberRegisterService regSvc = assembler.getMemberRegisterService();
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

        ChangePasswordService changePwdSvc = assembler.getChangePasswordService();

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
}
