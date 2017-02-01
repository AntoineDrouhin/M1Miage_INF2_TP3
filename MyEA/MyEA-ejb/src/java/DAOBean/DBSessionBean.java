/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOBean;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Kersa
 */
@Stateless
public class DBSessionBean implements DBSessionBeanLocal {

    private DAO<Book> BDAO;
    private DAO<Author> ADAO;
    
    public DBSessionBean() {
        BDAO = new BookDAO();
        ADAO = new AuthorDAO();
    }
    
    public List<Book> findAllBooks() {
        return BDAO.findAll();
    }
    
    public List<Author> findAllAuthors() {
        return ADAO.findAll();
    }
    
    public Book findBookById(int id) {
        return BDAO.findById(id);
    }
    
    public Author findAuthorById(int id) {
        return ADAO.findById(id);
    }
}
