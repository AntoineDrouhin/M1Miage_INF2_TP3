package fr.sorbonne.miage.m1.dao;

import java.util.List;

/**
 *
 * @author eddebbima
 */
public interface DAO<T> {
    
    public List<T> findAll();
    
    public void create(T obj);
    
    public T find(int id);
    
    public void update(T obj);
    
    public void delete(T obj);
    
}
