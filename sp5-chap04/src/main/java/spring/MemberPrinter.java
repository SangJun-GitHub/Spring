package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * Created by Sang Jun Park on 01/22/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberPrinter {

    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy,MM,dd");
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

    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter){
        this.dateTimeFormatter = dateTimeFormatter;
    }

//    @Autowired
//    public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt){
//        if(formatterOpt.isPresent()){
//            this.dateTimeFormatter = formatterOpt.get();
//        } else {
//            this.dateTimeFormatter = null;
//        }
//    }

//    @Autowired
//    public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter){
//        this.dateTimeFormatter = dateTimeFormatter;
//    }

}
