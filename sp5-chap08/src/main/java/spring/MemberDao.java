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
//    public Member selectByEmail(String email){
//        List<Member> results = jdbcTemplate.query(
//                "select * from MEMEBER where EMAIL = ?",
//                new RowMapper<Member>() {
//                    @Override
//                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Member member = new Member(
//                                rs.getString("EMAIL"),
//                                rs.getString("PASSWORD"),
//                                rs.getString("NAME"),
//                                rs.getTimestamp("REGDATE").toLocalDateTime());
//                        member.setId(rs.getLong("ID"));
//                        return member;
//                    }
//                }, email);
//        return results.isEmpty() ? null : results.get(0);
//    }
    public Member selectByEmail(String email){
        List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", new MemberRowMapper(), email);
        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member){

    }

    public void update(Member member){

    }

//    public List<Member> selectAll(){
//        List<Member> results = jdbcTemplate.query("select * from MEMBER", new RowMapper<Member>() {
//            @Override
//            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Member member = new Member(
//                        rs.getString("EMAIL"),
//                        rs.getString("PASSWORD"),
//                        rs.getString("NAME"),
//                        rs.getTimestamp("REGDATE").toLocalDateTime());
//                member.setId(rs.getLong("ID"));
//                return member;
//            }
//        });
//        return results;
//    }
    public List<Member> selectAll(){
        List<Member> results = jdbcTemplate.query("select * from MEMBER", new MemberRowMapper());
        return results;
    }

//    public int count(){
//        List<Integer> count = jdbcTemplate.query("select count(*) from MEMBER", new RowMapper<Integer>() {
//            @Override
//            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return rs.getInt(1);
//            }
//        });
//        return count.get(0);
//    }

    public int count(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
        return count;
    }
}
