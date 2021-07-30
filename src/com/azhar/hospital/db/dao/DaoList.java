package com.azhar.hospital.db.dao;

import java.util.List;

/**
 *
 * @author fastox
 */
public interface DaoList<T> {

    public List<T> loadAll();

    public boolean insert(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean Delete(T t) throws Exception;

    public T getData(T t) throws Exception;
}
