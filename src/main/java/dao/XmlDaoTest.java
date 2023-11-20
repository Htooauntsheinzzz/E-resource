package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class XmlDaoTest {
	@Autowired
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	 public int saveXml(String Data) {
	        
	            String Sql = "INSERT INTO `xml_db`(metadata) VALUES (?)";
				return template.update(Sql,Data); 
				
	            }
	        
	    }
	


