/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @book Antoine
 */
public class BookDAO implements DAO<Book> {
@PersistenceContext(unitName = "jpa_unit")
    private EntityManager em;
    
    @Override
    public List findAll() {
        Query query = em.createQuery("SELECT b FROM Book b");
        return (List<Book>) query.getResultList();
    }

    @Override
    public void create(Book book) {
        em.getTransaction().begin();        
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Book find(int id) {
        Book book = null;
        try {
            book = em.find(Book.class, id);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    @Override
    public void update(Book book) {
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Book book) {
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
        em.close();
    }
    
}
