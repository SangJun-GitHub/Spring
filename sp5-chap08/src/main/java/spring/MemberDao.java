package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sang Jun Park on 02/02/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public Member selectByEmail(String email){
        List<Member> result = jdbcTemplate.query(
                "select * from MEMEBER where EMAIL = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member(
                                rs.getString("EMAIL"),
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"),
                                rs.getTimestamp("REGDATE").toLocalDateTime());
                        member.setId(rs.getLong("ID"));
                        return member;
                    }
                }, email);
        return result.isEmpty() ? null : result.get(0);
    }

    public void insert(Member member){

    }

    public void update(Member member){

    }

    public Collection<Member> selectAll(){
        return null;
    }
}
