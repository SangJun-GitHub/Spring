package spring;

import java.util.Collection;

/**
 * Created by Sang Jun Park on 01/21/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter printer;

    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer){
        this.memberDao = memberDao;
        this.printer = printer;
    }

    public void printAll(){
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> printer.print(m));
    }
}
