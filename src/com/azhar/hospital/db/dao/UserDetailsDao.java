package com.azhar.hospital.db.dao;

import com.azhar.hospital.db.type.UsersType;
import com.azhar.hospital.db.vo.UserDetailsVo;
import com.azhar.hospital.db.vo.UsersVo;
import com.azhar.hospital.view.UsersView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

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
    public int insert(UserDetailsVo udv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String userSql = "INSERT INTO users(USER_NAME,PASSWORD,USER_TYPE,ID) VALUES(?,?,?,?)";
            ps = con.prepareStatement(userSql);
            ps.setString(1, udv.getUsersVo().getUserName());
            ps.setString(2, udv.getUsersVo().getPassword());
            ps.setInt(3, udv.getUsersVo().getUsersType().getId());
            ps.setInt(4, udv.getUsersVo().getId());
            ps.executeUpdate();

            String userDetailsSql = "INSERT INTO users_details (USER_ID, FIRST_NAME, FATHER_NAME, MOBILE, IMAGE, SPECIALIZATION) VALUES(?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(userDetailsSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.setString(2, udv.getFirstName());
            ps.setString(3, udv.getFatherName());
            ps.setString(4, udv.getMobile());
            ps.setBytes(5, udv.getImage());
            ps.setString(6, udv.getSpecialization());
            ps.executeUpdate();
            con.commit();

            count = 1;

        } catch (Exception ex) {
            con.rollback();
        } finally {
            ps.close();
            closeConnection(con);
        }
        return count;
    }

    @Override
    public int update(UserDetailsVo udv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String userSql = "UPDATE USERS SET USER_NAME=?,PASSWORD=?,USER_TYPE=? WHERE ID=?";
            ps = con.prepareStatement(userSql);
            ps.setString(1, udv.getUsersVo().getUserName());
            ps.setString(2, udv.getUsersVo().getPassword());
            ps.setInt(3, udv.getUsersVo().getUsersType().getId());
            ps.setInt(4, udv.getUsersVo().getId());
            ps.executeUpdate();

            String userDetailsSql = "UPDATE users_details SET FIRST_NAME=?, FATHER_NAME=?, MOBILE=?, IMAGE=?, SPECIALIZATION=? WHERE USER_ID=?";
            ps = con.prepareStatement(userDetailsSql);
            ps.setString(1, udv.getFirstName());
            ps.setString(2, udv.getFatherName());
            ps.setString(3, udv.getMobile());
            ps.setBytes(4, udv.getImage());
            ps.setString(5, udv.getSpecialization());
            ps.setInt(6, udv.getUsersVo().getId());

            ps.executeUpdate();
            con.commit();

            count = 1;

        } catch (Exception ex) {
            con.rollback();
        } finally {
            ps.close();
            closeConnection(con);
        }
        return count;
    }

    @Override
    public int Delete(UserDetailsVo udv) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            String userDetailsSql = "DELETE FROM users_details WHERE USER_ID=?";
            ps = con.prepareStatement(userDetailsSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.executeUpdate();

            String userSql = "DELETE FROM users WHERE ID=?";
            ps = con.prepareStatement(userSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.executeUpdate();
            con.commit();
            count = 1;

        } catch (Exception ex) {
            con.rollback();
        } finally {
            ps.close();
            closeConnection(con);
        }
        return count;
    }

    @Override
    public UserDetailsVo getData(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDetailsVo getDataById(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserDetailsVo userDetailsVo = null;
        UsersVo usersVo = null;
        try {
            con = getConnection();

            String userSql = "SELECT USERS.ID, USERS.USER_NAME, USERS.PASSWORD, USERS.USER_TYPE, USERS_DETAILS.FIRST_NAME, USERS_DETAILS.FATHER_NAME, USERS_DETAILS.MOBILE, USERS_DETAILS.IMAGE, USERS_DETAILS.SPECIALIZATION FROM USERS INNER JOIN USERS_DETAILS ON USERS.ID = USERS_DETAILS.USER_ID WHERE USERS.ID=?";
            ps = con.prepareStatement(userSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                usersVo = new UsersVo();
                userDetailsVo = new UserDetailsVo();
                usersVo.setId(rs.getInt("ID"));
                usersVo.setUserName(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));
                UsersType usersType = UsersType.getUserTypeById(rs.getInt("USER_TYPE"));
                usersVo.setUsersType(usersType);
                userDetailsVo.setFirstName(rs.getString(("FIRST_NAME")));
                userDetailsVo.setFatherName(rs.getString("FATHER_NAME"));
                userDetailsVo.setMobile(rs.getString("MOBILE"));
                userDetailsVo.setImage(rs.getBytes("IMAGE"));
                userDetailsVo.setSpecialization(rs.getString("SPECIALIZATION"));
                userDetailsVo.setUsersVo(usersVo);
            }

        } catch (Exception ex) {
        } finally {
            rs.close();
            ps.close();
            closeConnection(con);
        }
        return userDetailsVo;
    }

}
