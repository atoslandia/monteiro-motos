package com.atosalves.dao.interfaceDAO;

public interface UpdateDAO<U,T,K> {
    
    public U update(T entidade, K id);
}
