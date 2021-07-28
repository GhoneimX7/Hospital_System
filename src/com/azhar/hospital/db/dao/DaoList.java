package com.azhar.hospital.db.dao;

import java.util.List;

/**
 *
 * @author fastox
 */
public interface DaoList<T>{
    public List<T> loadAll();
    public String insert() throws Exceptions;
    public String update()throws Exceptions;
    public String Delete()throws Exceptions;
    public T getData(T t)throws Exceptions;
}
