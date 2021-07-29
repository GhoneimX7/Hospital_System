package com.azhar.hospital.db.dao;

import com.azhar.hospital.db.type.UsersType;
import com.azhar.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author fastox
 */
public class UsersDao extends Dao implements DaoList <UsersVo> {
    private static UsersDao usersDao;
    private UsersDao() {
        
    }
    public static UsersDao getInstance() {
        if (usersDao==null) {
            usersDao = new UsersDao();
        }
        return usersDao;
    }

    @Override
    public List<UsersVo> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Delete() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsersVo getData(UsersVo uv) throws Exception {
            Connection con = null;
            UsersVo usersVo = null;
            ResultSet rs = null;
            try{
                con = getConnection();
                String sql = "SELECT * FROM users WHERE USER_NAME='" + uv.getUserName() + "' AND PASSWORD='" + uv.getPassword() + "'";
                PreparedStatement ps = con.prepareCall(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    usersVo = new UsersVo();
                    usersVo.setId(rs.getInt("id"));
                    usersVo.setUserName(rs.getString("USER_NAME"));
                    usersVo.setPassword(rs.getString("PASSWORD"));
                    UsersType usersType = UsersType.getUserTypeById(rs.getInt("USER_TYPE"));
                    usersVo.setUsersType(usersType);
                    
                }
            }catch(Exception ex){
                
            }
            return usersVo;
    }
}
