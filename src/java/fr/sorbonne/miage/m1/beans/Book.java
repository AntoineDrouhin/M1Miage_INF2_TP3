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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "Book")
@Access(AccessType.FIELD)
public class Book implements Serializable  {
    
    @Id
    @Column(nullable = false, unique= true, precision = 11)
    private Integer isbn;
    
    @Column(nullable = false, length = 255 )
    private String title;
    
    @Column(nullable = false, precision = 5, scale = 2 )
    private Float price;
    
    @ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(name = "Author",
         joinColumns = @JoinColumn(name = "isbn", referencedColumnName = "isbn"),
         inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
     private Collection<Author> authors;
    
    
    
    public Book(Integer isin, String title, Float price) {
        this.isbn = isin;
        this.title = title;
        this.price = price;
    }

    public Book() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
