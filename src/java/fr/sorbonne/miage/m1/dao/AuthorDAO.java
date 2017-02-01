/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eddebbima
 */
public class AuthorDAO implements DAO<Author>{
    
    private EntityManager em;
      
    public AuthorDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void create(Author obj) {    
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    public Author findById(int id) {
        return em.find(Author.class, id);
    }

    public void update(Author obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Author obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }

    public List<Author> findAll() {
        List<Author> listAuthor = em.createQuery("Select b FROM Book b").getResultList();
        return listAuthor;
    }
}
