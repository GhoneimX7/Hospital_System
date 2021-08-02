package com.azhar.hospital.db.dao;

import java.util.List;

/**
 *
 * @author fastox
 */
public interface DaoList<T> {

    public List<T> loadAll();

    public int insert(T t) throws Exception;

    public int update(T t) throws Exception;

    public int Delete(T t) throws Exception;

    public T getData(T t) throws Exception;
    
    public T getDataById(int id) throws Exception;
}
