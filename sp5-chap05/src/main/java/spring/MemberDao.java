package spring;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sang Jun Park on 01/24/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component
public class MemberDao {
    private static long nextId = 0;

    private Map<String, Member> map = new HashMap<>();

    public Member selectByEmail(String email){
        return map.get(email);
    }

    public void insert(Member member){
        member.setId(++nextId);
        map.put(member.getEmail(), member);
    }

    public void update(Member member){
        map.put(member.getEmail(), member);
    }

    public Collection<Member> selectAll(){
        return map.values();
    }
}
