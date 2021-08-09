/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azhar.hospital.db.dao;

import com.azhar.hospital.db.vo.PatientInfoVo;
import com.azhar.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author fastox
 */
public class PatientInfoDao extends Dao implements DaoList<PatientInfoVo> {

    private static PatientInfoDao patientInfoDao;

    private PatientInfoDao() {

    }

    public static PatientInfoDao getInstance() {
        if (patientInfoDao == null) {
            patientInfoDao = new PatientInfoDao();
        }
        return patientInfoDao;
    }

    @Override
    public List<PatientInfoVo> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(PatientInfoVo piv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            con = getConnection();
            String userSql = "INSERT INTO PATIENT_INFO(ID,FIRST_NAME,FATHER_NAME,MOBILE,EMAIL,USER_ID) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(userSql);
            ps.setInt(1, piv.getId());
            ps.setString(2, piv.getFirstName());
            ps.setString(3, piv.getFatherName());
            ps.setString(4, piv.getMobile());
            ps.setString(5, piv.getEmail());
            ps.setInt(6, piv.getUsersVo().getId());
            count = ps.executeUpdate();

        } catch (Exception ex) {
        } finally {
            ps.close();
            closeConnection(con);
        }
        return count;
    }

    @Override
    public int update(PatientInfoVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Delete(PatientInfoVo piv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            con = getConnection();
            String sql = "DELETE FROM PATIENT_INFO WHERE ID=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, piv.getId());
            count = ps.executeUpdate();
        } catch (Exception ex) {
        } finally {
            ps.close();
            closeConnection(con);
        }
        return count;
    }

    @Override
    public PatientInfoVo getData(PatientInfoVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PatientInfoVo getDataById(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PatientInfoVo patientInfoVo = null;
        UsersVo usersVo = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM patient_info WHERE ID=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                patientInfoVo = new PatientInfoVo();
                usersVo = new UsersVo();
                usersVo.setId(rs.getInt("USER_ID"));

                patientInfoVo.setId(rs.getInt("ID"));
                patientInfoVo.setFirstName(rs.getString("FIRST_NAME"));
                patientInfoVo.setFatherName(rs.getString("FATHER_NAME"));
                patientInfoVo.setMobile(rs.getString("MOBILE"));
                patientInfoVo.setEmail(rs.getString("EMAIL"));
                patientInfoVo.setUsersVo(usersVo);
            }

        } catch (Exception ex) {
        } finally {
            rs.close();
            ps.close();
            closeConnection(con);
        }
        return patientInfoVo;

    }
}
