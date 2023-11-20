package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import beans.collection;


public class CollectionDao {
JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template=template;
}
public int save(collection col) {
	String sql="insert into collections(collectionname)values(?)";
	return template.update(sql,col.getCollection());
	
}
/*public List<Collection> getCollection() {
	return template.query("select collectionname from collections", new RowMapper<Collection>() {
		public Collection mapRow(ResultSet rs, int row) throws SQLException {
			Collection col = new Collection();
			col.setCollection(rs.getString(1));
			return col;
		}
	});*/
}

