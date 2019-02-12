package test.task.user.crud;

import org.apache.log4j.Logger;
import test.task.user.pojo.User;
import test.task.user.service.GendersList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public class UsersCrud implements Crud {

    private static final Logger LOGGER = Logger.getLogger(UsersCrud.class);

    private static final String SQLSELECT = "select id, name, surName, email, birthday, gender from customer.users";
    private static final String SQLINSERT = "insert into customer.users(name, surName, email, birthday, gender) " +
            " values(?, ?, ?, ?, ?)";
    private static final String SQLDELETE = "delete from customer.users where id = ?";

    public UsersCrud() {

    }

    @Override
    public List Select(DataSource ds) {
        List<User> listUser = Collections.synchronizedList(new LinkedList<>());

        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();
            rs = st.executeQuery(SQLSELECT);
            try {
                while (rs.next()) {
                    listUser.add(new User(rs.getLong("id"), rs.getString("name"), rs.getString("surName"),
                                    rs.getString("email"), rs.getDate("birthday"),
                                    GendersList.getGenders(rs.getInt("gender"))
                            )
                    );
                }
                conn.commit();
            } finally {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (st != null && !st.isClosed()) {
                    st.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            LOGGER.info(ex);
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (st != null && !st.isClosed()) {
                    st.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.rollback();
                    conn.close();
                }
            } catch (SQLException ex1) {
                LOGGER.info(ex1);
            }
        }

        return listUser;
    }

    @Override
    public int Insert(DataSource ds, Object o) {
        if (o == null || !(o instanceof User)) {
            throw new NullPointerException("o == null || !(o instanceof User)");
        }
        int i = 0;
        User user = (User) o;

        Connection conn = null;
        PreparedStatement ins = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            ins = conn.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);
            ins.setString(1, user.getName());
            ins.setString(2, user.getSurName());
            ins.setString(3, user.getEmail());
            ins.setTimestamp(4, new Timestamp(user.getBirthday().getTime()));
            ins.setInt(5, user.getGender().getId());
            try {
                ins.executeUpdate();

                rs = ins.getGeneratedKeys();
                if (rs.next()) {
                    user.setId(rs.getLong(1));
                }
                conn.commit();
            } finally {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (ins != null && !ins.isClosed()) {
                    ins.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            LOGGER.info(ex);
            i = -1;
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (ins != null && !ins.isClosed()) {
                    ins.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.rollback();
                    conn.close();
                }
            } catch (SQLException ex1) {
                LOGGER.info(ex1);
            }
        }
        return i;
    }

    @Override
    public int Delete(DataSource ds, Long id) {
        int i = 0;

        Connection conn = null;
        PreparedStatement ins = null;
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            ins = conn.prepareStatement(SQLDELETE);
            ins.setLong(1, id);
            try {
                ins.executeUpdate();

                conn.commit();
            } finally {
                if (ins != null && !ins.isClosed()) {
                    ins.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            LOGGER.info(ex);
            i = -1;
            try {
                if (ins != null && !ins.isClosed()) {
                    ins.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.rollback();
                    conn.close();
                }
            } catch (SQLException ex1) {
                LOGGER.info(ex1);
            }
        }
        return i;
    }
}
