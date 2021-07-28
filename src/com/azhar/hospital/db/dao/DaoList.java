package com.azhar.hospital.db.dao;

import java.util.List;

/**
 *
 * @author fastox
 */
public interface DaoList<T>{
    public List<T> loadAll();
    public String insert();
    public String update();
    public String Delete();
    public T getData(T t);
}
