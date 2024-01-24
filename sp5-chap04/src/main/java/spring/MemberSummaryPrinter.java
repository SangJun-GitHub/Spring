package spring;

/**
 * Created by Sang Jun Park on 01/22/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberSummaryPrinter extends MemberPrinter{

    @Override
    public void print(Member member){
        System.out.printf("Member Info : Email = %s, Name = %s\n",
                member.getEmail(), member.getName());
    }
}
