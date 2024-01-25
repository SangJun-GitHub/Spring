package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sang Jun Park on 01/24/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component("infoPrinter")
public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    @Autowired
    public void setPrinter(MemberPrinter printer){
        this.printer = printer;
    }

    public void printerMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);

        if(member == null) {
            System.out.println("No Data\n");
            return;
        }

        printer.print(member);
        System.out.println();
    }
}
