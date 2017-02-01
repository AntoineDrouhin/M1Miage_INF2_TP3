package fr.sorbonne.miage.m1.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Antoine, Aurelien
 */
@Entity
@Table(name = "Author")
@Access(AccessType.FIELD)
public class Author implements Serializable {
    
    @Id
    @Column(nullable = false, unique= true, precision = 11)
    private int id;
    
    @Column(nullable = false, length = 255 )
    private String firstname;
    
    @Column(nullable = false, length = 255 )
    private String lastname;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "Book")
    private Collection<Book> books;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @return the books
     */
    public Collection<Book> getBooks() {
        return books;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
}
