package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.Member;
import spring.MemberDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Sang Jun Park on 02/06/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MainForMemberDao {

    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        memberDao = ctx.getBean(MemberDao.class);

        selectAll();
        updateMember();
        insertMember();

        ctx.close();
    }

    private static void selectAll(){
        System.out.println("----- selectAll");
        int total = memberDao.count();
        System.out.println("Number of data : " + total);
        List<Member> members = memberDao.selectAll();
        for(Member m : members){
            System.out.println(m.getId() + " : " + m.getEmail() + " [" + m.getName() + "]");
        }
    }

    private static void updateMember(){
        System.out.println("----- updateMember");
        Member member = memberDao.selectByEmail("abc@abc.com");
        String oldPw = member.getPassword();
        String newPw = Double.toHexString(Math.random());
        member.changePassword(oldPw, newPw);
        memberDao.update(member);
        System.out.println("Change Password : " + oldPw + " -> " + newPw);
    }

    private static void insertMember(){
        System.out.println("----- insetMember");
        String prefix = formatter.format(LocalDateTime.now());
        Member member = new Member(prefix + "@test.com", prefix, prefix, LocalDateTime.now());
        memberDao.insert(member);
        System.out.println("Inserted Member : " + member.getId());
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMddHHmmss");
}
