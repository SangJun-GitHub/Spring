package spring;

/**
 * Created by Sang Jun Park on 02/03/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);

        if(member == null){
            System.out.println("No Data\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }

    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void setPrinter(MemberPrinter printer){
        this.printer = printer;
    }
}
