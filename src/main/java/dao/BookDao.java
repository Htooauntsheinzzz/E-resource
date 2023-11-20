package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import beans.Book;

@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template) {
    	this.template=template;
    }

    public int insertBook(Book b) {
    	System.out.println(b.getAuthor());
        return template.update("INSERT INTO books (title, author, collection) VALUES (?, ?, ?)",
                b.getTitle(), b.getAuthor(), b.getCollection());
        
    }
}
