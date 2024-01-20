package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * Created by Sang Jun Park on 01/19/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class Assembler {
    private MemberDao memberDao;
    private MemberRegisterService regSvc;
    private ChangePasswordService pwdSvc;

    public Assembler(){
        memberDao = new MemberDao();
        //Construct Injection
        regSvc = new MemberRegisterService(memberDao);
        pwdSvc = new ChangePasswordService();
        //Setter Injection
        pwdSvc.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao(){
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService(){
        return regSvc;
    }

    public ChangePasswordService getChangePasswordService(){
        return pwdSvc;
    }
}
