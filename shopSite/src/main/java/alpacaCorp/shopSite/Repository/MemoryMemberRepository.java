package alpacaCorp.shopSite.Repository;

import alpacaCorp.shopSite.DTO.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    DataSource dataSource;
    CommonJDBC commonJDBC;

    @Autowired
    public MemoryMemberRepository(DataSource dataSource, CommonJDBC commonJDBC) {
        this.dataSource = dataSource;
        this.commonJDBC = commonJDBC;
    }

    @Override
    public boolean userJoin(Member member) {
        String sql = "INSERT INTO members(id, name, password) VALUES(?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPassword());
//            pstmt.setString(4, member.getColor());
//            pstmt.setString(5, member.getImg());
//            pstmt.setString(6, member.getStart_date());
//            pstmt.setString(7, member.getEnd_date());

            int i = pstmt.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            commonJDBC.close(conn, pstmt, rs);
        }
        return false;
    }

    @Override
    public Optional<Member> findById(Long id) {
        String sql = "SELECT * FROM members WHERE id=?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Member member = new Member();

                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));
                member.setColor(rs.getString("color"));
                member.setImg(rs.getString("img"));
                member.setStart_date(rs.getString("start_date"));
                member.setEnd_date(rs.getString("end_date"));

                return Optional.of(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            commonJDBC.close(conn, pstmt, rs);
        }
        return Optional.empty();
    }

    @Override
    public List<Member> findByName(String name) {
        String sql = "SELECT * FROM members WHERE name=?";

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            List<Member> members = new ArrayList<>();

            while (rs.next()) {
                Member member = new Member();

                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));
                member.setColor(rs.getString("color"));
                member.setImg(rs.getString("img"));
                member.setStart_date(rs.getString("start_date"));
                member.setEnd_date(rs.getString("end_date"));

                members.add(member);
            }
            return members;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            commonJDBC.close(conn, pstmt, rs);
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        String sql = "SELECT * FROM members";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            List<Member> members = new ArrayList<>();

            while (rs.next()) {
                Member member = new Member();

                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                member.setPassword(rs.getString("password"));
                member.setColor(rs.getString("color"));
                member.setImg(rs.getString("img"));
                member.setStart_date(rs.getString("start_date"));
                member.setEnd_date(rs.getString("end_date"));

                members.add(member);
            }
            return members;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            commonJDBC.close(conn, pstmt, rs);
        }
        return null;
    }

    @Override
    public Member findMember(Member member) {
        String sql = "SELECT name FROM members WHERE id=? and password=?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, member.getId());
            pstmt.setString(2, member.getPassword());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                member.setName(rs.getString("name"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            commonJDBC.close(conn, pstmt, rs);
        }
        return member;
    }
}