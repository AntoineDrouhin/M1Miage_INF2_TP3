/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOBean;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kersa
 */
@Local
public interface DBSessionBeanLocal {
    public List<Book> findAllBooks();
    
    public List<Author> findAllAuthors();
    
    public Book findBookById(int id);
    
    public Author findAuthorById(int id);
}
