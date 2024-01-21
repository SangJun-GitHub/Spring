package spring;

/**
 * Created by Sang Jun Park on 01/21/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberPrinter {

    public void print(Member member){
        System.out.printf("Member Info : Id = %d, Email = %s, Name = %s, Register Date = %tF\n",
                member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
    }
}
