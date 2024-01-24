package spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Created by Sang Jun Park on 01/22/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberRegisterService {
    @Autowired

    private MemberDao memberDao;

    public MemberRegisterService(){

    }

    public Long register(RegisterRequest req){
        Member member = memberDao.selectByEmail(req.getEmail());

        if(member != null)
            throw new DuplicateMemberException("dup email " + req.getEmail());

        Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
