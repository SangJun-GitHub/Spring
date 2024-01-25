package spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

/**
 * Created by Sang Jun Park on 01/24/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy,MM,dd");
    }

    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter){
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public void print(Member member){
        if(dateTimeFormatter == null) {
            System.out.printf("Member Info : Id = %d, Email = %s, Name = %s, Register Date = %tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf("Member Info : Id = %d, Email = %s, Name = %s, Register Date = %s\n",
                    member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }

}
