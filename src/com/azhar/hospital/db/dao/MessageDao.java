/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azhar.hospital.db.dao;

import com.azhar.hospital.db.vo.MessageVo;
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
public class MessageDao extends Dao implements DaoList<MessageVo> {

    private static MessageDao messageDao;

    private MessageDao() {

    }

    public static MessageDao getInstance() {
        if (messageDao == null) {
            messageDao = new MessageDao();
        }
        return messageDao;
    }

    @Override
    public List<MessageVo> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(MessageVo mv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            con = getConnection();
            String sql = "INSERT INTO MESSAGES(MESSAGE_BODY, MESSAGE_DATE, FROM_USER, TO_USER, PATIENT_ID) VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, mv.getMessageBody());
            ps.setDate(2, mv.getMessageDate());
            ps.setInt(3, mv.getFromUser().getId());
            ps.setInt(4, mv.getToUser().getId());
            ps.setInt(5, mv.getPatientInfoVo().getId());
            count = ps.executeUpdate();
        } catch (Exception ex) {
        } finally {
            ps.close();
            closeConnection(con);
        }
        return count;
    }

    @Override
    public int update(MessageVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Delete(MessageVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MessageVo getData(MessageVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MessageVo getDataById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public MessageVo getDataByPatientIdAndUserId(int patientId, int userId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MessageVo messageVo = null;
        PatientInfoVo patientInfoVo = null;
        UsersVo toUser = null;
        UsersVo fromUser = null;
        try {
            con = getConnection();
            String sql = "SELECT FROM MESSAGES ID, MESSAGE_BODY, MESSAGE_DATE, FROM_USER, TO_USER, PATIENT_ID WHERE TO_USER=? AND PATIENT_ID=? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, patientId);
            rs = ps.executeQuery();

            while (rs.next()) {
                messageVo = new MessageVo();
                messageVo.setId(rs.getInt("ID"));
                messageVo.setMessageBody(rs.getString("MESSAGE_BODY"));
                messageVo.setMessageDate(rs.getDate("MESSAGE_DATE"));
                fromUser = new UsersVo();
                fromUser.setId(rs.getInt("FROM_USER"));
                toUser = new UsersVo();
                toUser.setId(rs.getInt("TO_USER"));
                patientInfoVo = new PatientInfoVo();
                patientInfoVo.setId(rs.getInt("PATIENT_ID"));
                messageVo.setFromUser(fromUser);
                messageVo.setToUser(toUser);
                messageVo.setPatientInfoVo(patientInfoVo);
            }

        } catch (Exception ex) {
        } finally {
            rs.close();
            ps.close();
            closeConnection(con);
        }
        return messageVo;

    }
}
