/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eddebbima
 */
public class BookDAO implements DAO<Book> {

    private EntityManager em;

    public BookDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Book obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Book findById(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public void update(Book obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Book obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Book> findAll() {
        List<Book> listBook = em.createQuery("Select b FROM Book b").getResultList();
        return listBook;
    }

}
