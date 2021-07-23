package alpacaCorp.shopSite.Repository;

import alpacaCorp.shopSite.DTO.Profile;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemoryProfileRepository implements ProfileRepository{

    DataSource dataSource;
    CommonJDBC commonJDBC;

    @Autowired
    public MemoryProfileRepository(DataSource dataSource, CommonJDBC commonJDBC) {
        this.dataSource = dataSource;
        this.commonJDBC = commonJDBC;
    }

    @Override
    public Profile save(Profile profile) {
        // id, name, color, img, start_date, end_date
        String sql = "INSERT INTO profile VLAUES(?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, profile.getId());
            pstmt.setString(2, profile.getName());
            pstmt.setString(3, profile.getColor());
            pstmt.setString(4, profile.getImg());
            pstmt.setString(5, profile.getStart_date());
            pstmt.setString(6, profile.getEnd_date());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            commonJDBC.close(conn, pstmt, rs);
        }
        return null;
    }

    @Override
    public List<Profile> findAll() {
        String sql = "SELECT * FROM profile";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            List<Profile> profiles = new ArrayList<>();

            while(rs.next()) {
                Profile profile = new Profile();

                profile.setId(rs.getString("id"));
                profile.setName(rs.getString("name"));
                profile.setColor(rs.getString("color"));
                profile.setImg(rs.getString("img"));
                profile.setStart_date(rs.getString("start_date"));
                profile.setEnd_date(rs.getString("end_date"));

                profiles.add(profile);
            }

            return profiles;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            commonJDBC.close(conn, pstmt, rs);
        }

        return null;
    }
}
