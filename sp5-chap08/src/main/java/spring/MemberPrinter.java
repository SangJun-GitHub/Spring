package spring;

/**
 * Created by Sang Jun Park on 02/03/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberPrinter {

    public void print(Member member){
        System.out.printf("Member Info : Id=%d, email=%s, name=%s, register date=%tF\n",
                member.getId(),
                member.getEmail(),
                member.getName(),
                member.getRegisterDateTime());
    }
}
