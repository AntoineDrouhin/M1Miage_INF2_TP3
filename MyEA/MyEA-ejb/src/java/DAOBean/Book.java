package DAOBean;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Book")
@Access(AccessType.FIELD)
public class Book implements Serializable {
    
    @Id
    @Column(nullable = false, unique = true)
    private Integer isbn;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private Float price;
    
    @ManyToMany
    @JoinTable(name = "Compo_Author_Book",
        joinColumns = @JoinColumn(name = "isbn_cab", referencedColumnName = "isbn"),
        inverseJoinColumns = @JoinColumn(name="id_cab", referencedColumnName = "id")
    )    
        
    private List<Author> sesAuteurs;
   
          
    public Book() {
        this.isbn = null;
        this.title = null;
        this.price = null;
    }
    
    public Book(Integer isin, String title, Float price) {
        this.isbn = isin;
        this.title = title;
        this.price = price;
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
