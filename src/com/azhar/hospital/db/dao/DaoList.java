package com.azhar.hospital.db.dao;

import java.util.List;

/**
 *
 * @author fastox
 */
public interface DaoList<T>{
    public List<T> loadAll();
    public String insert() throws Exception;
    public String update()throws Exception;
    public String Delete()throws Exception;
    public T getData(T t)throws Exception;
}
