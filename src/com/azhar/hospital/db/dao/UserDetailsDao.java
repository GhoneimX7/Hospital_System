package com.azhar.hospital.db.dao;

import com.azhar.hospital.db.vo.UserDetailsVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author fastox
 */
public class UserDetailsDao extends Dao implements DaoList<UserDetailsVo> {

    private static UserDetailsDao userDetailsDao;

    private UserDetailsDao() {

    }

    public static UserDetailsDao getInstance() {
        if (userDetailsDao == null) {
            userDetailsDao = new UserDetailsDao();
        }
        return userDetailsDao;
    }

    @Override
    public List<UserDetailsVo> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(UserDetailsVo udv) throws Exception {
        Connection con = null;
        boolean isInsert = false;
        try {
            con = getConnection();
            String sql = "INSERT INTO users_details (USER_ID, FIRST_NAME, FATHER_NAME, MOBILE) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.setString(2, udv.getFirstName());
            ps.setString(3, udv.getFatherName());
            ps.setString(4, udv.getMobile());
            isInsert = ps.execute();
            ps.close();
        } catch (Exception ex) {

        } finally {
            closeConnection(con);
        }
        return isInsert;
    }

    @Override
    public boolean update(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDetailsVo getData(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
