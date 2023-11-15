package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import beans.user;

@Repository
public class ItemDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<user> getUsers() {
		return template.query(
				"select * from usertb",
				new RowMapper<user>() {
					public user mapRow(ResultSet rs, int row) throws SQLException {
						user e = new user();
						e.setId(rs.getInt(1));
						e.setFirstname(rs.getString(2));;
						e.setLastname(rs.getString(3));
						e.setEmail(rs.getString(4));
						return e;
					}
				});
	}

	public int save(user u) {		
		String sql = "INSERT INTO usertb(firstname, lastname, email) VALUES(?,?,?)";
		return template.update(sql,
				new Object[] { u.getFirstname(), u.getLastname(), u.getEmail()});		
	}

	public user getUserById(int id) {
		String sql = "select id,firstname,lastname,email from usertb where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<user>(user.class));
	}

	public int update(user user) {
		String sql = "UPDATE usertb SET firstname='" + user.getFirstname() + "',lastname='"+user.getLastname()+"',email='"+user.getEmail()+"' WHERE id=" + user.getId() + "";
		return template.update(sql);		
	}

	public int delete(int id) {
			String sql = "delete from usertb where id=" + id + "";
			return template.update(sql);			
	}
}
