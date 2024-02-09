package spring;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sang Jun Park on 02/03/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class ChangePasswordService {

    private MemberDao memberDao;

    @Transactional
    public void changePassword(String email, String oldPwd, String newPwd){
        Member member = memberDao.selectByEmail(email);

        if(member == null)
            throw new MemberNotFoundException();

        member.changePassword(oldPwd, newPwd);
        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
}
