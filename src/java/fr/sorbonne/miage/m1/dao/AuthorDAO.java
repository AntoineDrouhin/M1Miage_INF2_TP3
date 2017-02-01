/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Antoine
 */
public class AuthorDAO implements DAO<Author> {

    @PersistenceContext(unitName = "jpa_unit")
    private EntityManager em;
    
    @Override
    public List findAll() {
        Query query = em.createQuery("SELECT a FROM Author a");
        return (List<Author>) query.getResultList();
    }

    @Override
    public void create(Author author) {
        em.getTransaction().begin();        
        em.persist(author);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Author find(int id) {
        Author author = null;
        try {
            author = em.find(Author.class, id);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return author;
    }

    @Override
    public void update(Author author) {
        em.getTransaction().begin();
        em.merge(author);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Author author) {
        em.getTransaction().begin();
        em.remove(author);
        em.getTransaction().commit();
        em.close();
    }
    
}
