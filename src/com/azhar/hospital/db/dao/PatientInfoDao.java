/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azhar.hospital.db.dao;

import com.azhar.hospital.db.vo.PatientInfoVo;
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
    public int insert(PatientInfoVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(PatientInfoVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Delete(PatientInfoVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PatientInfoVo getData(PatientInfoVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PatientInfoVo getDataById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
