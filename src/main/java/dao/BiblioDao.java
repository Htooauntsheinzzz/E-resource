
  package dao;
  
  import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import beans.biblio;
import beans.collection;
  
  public class BiblioDao { JdbcTemplate template;
  
  public void setTemplate(JdbcTemplate template) { 
	  this.template=template; 
	  }
  public int save(biblio b) { 
  String sql="insert into bibliodb (title,author,coauthor1,coauthor2,coauthor3,coauthor4,collection,publicationyear,publishercode,place,subject1,subject2,subject3,subject4,editionstatement,content,summary,description) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  
  return template.update(sql, new Object[] { b.getTitle(),
  b.getAuthor(),b.getCoauthor1(),b.getCoauthor2(),b.getCoauthor3(),b.getCoauthor4(),b.getCollection(),b.getPublicationyear(),b.getPublishercode(),b.getPlace(),b.getSubject1(),b.getSubject2(),b.getSubject3(),b.getSubject4(),b.getEditionstatement(),b.getContent(),b.getSummary(),b.getDescription()}); 
  } 
 
	public List<collection> getCollection() {
		return template.query("select collectionname from collections", new RowMapper<collection>() {
			public collection mapRow(ResultSet rs, int row) throws SQLException {
				collection e = new collection();
				e.setCollection(rs.getString(1));
				return e;
			}
		});
	}
	}