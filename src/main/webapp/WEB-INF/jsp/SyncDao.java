package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import beans.ItemTypes;
import beans.Patron;
import beans.SyncData;

public class SyncDao implements ISyncDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	String BIBLIOSELECT = "select b.title,"
			+ " replace(coalesce(extractvalue(bm.metadata, '//datafield[@tag=\\\"245\\\"]/subfield[@code=\\\"c\\\"]'),b.author), '|', '') as author,"
			+ " replace(extractvalue(bm.metadata, '//datafield[@tag=\"700\"]/subfield[@code=\"a\" or @code=\"c\" or @code=\"g\" or @code=\"d\"] | //datafield[@tag=\"710\"]/subfield[@code=\"a\" or @code=\"b\" or @code=\"c\" or @code=\"d\"] | //datafield[@tag=\"110\"]/subfield[@code=\"a\" or @code=\"b\" or @code=\"c\" or @code=\"d\"] | //datafield[@tag=\"100\"]/subfield[@code=\"a\" or @code=\"b\" or @code=\"c\" or @code=\"g\" or @code=\"d\" or @code=\"q\"]'), '|', '') as coauthor,"
			+ " coalesce(b.notes, extractvalue(bm.metadata, '//datafield[@tag=\"500\"]/subfield[@code=\"a\"]')) as b_notes,"
			+ " replace(coalesce(bi.publicationyear, extractvalue(bm.metadata, '//datafield[@tag=\"260\"]/subfield[@code=\"c\"]')),'|','') as publicationyear,"
			+ " coalesce(bi.publishercode, extractvalue(bm.metadata, '//datafield[@tag=\"260\"]/subfield[@code=\"b\"]')) as publishercode,"
			+ " coalesce(bi.place, extractvalue(bm.metadata, '//datafield[@tag=\"260\"]/subfield[@code=\"a\"]')) as place,"
			+ " coalesce(bi.editionstatement, extractvalue(bm.metadata, '//datafield[@tag=\"250\"]/subfield[@code=\"a\"]')) as editionstatement,"										
			+ " replace(concat(extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"a\\\" or @code=\\\"b\\\" or @code=\\\"c\\\" or @code=\\\"g\\\" or @code=\\\"d\\\"]'),' ',IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"v\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"v\\\"]'))),IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"x\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"x\\\"]'))),IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"y\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"y\\\"]'))),IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"z\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"600\\\"]/ subfield[@code=\\\"z\\\"]'))),' ',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"a\\\" or @code=\\\"b\\\" or @code=\\\"c\\\" or @code=\\\"d\\\" or @code=\\\"e\\\" or @code=\\\"f\\\" or @code=\\\"h\\\"]'),' ',IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"v\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"v\\\"]'))),IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"x\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"x\\\"]'))),IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"y\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"y\\\"]'))),IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"z\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"610\\\"]/ subfield[@code=\\\"z\\\"]'))),' ',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"a\\\"]'),' ',IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"v\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"v\\\"]'))), IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"x\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"x\\\"]'))), IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"y\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"y\\\"]'))), IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"z\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"650\\\"]/ subfield[@code=\\\"z\\\"]'))),' ',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"a\\\"]'),' ',IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"v\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"v\\\"]'))), IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"x\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"x\\\"]'))), IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"y\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"y\\\"]'))), IF(concat('--',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"z\\\"]'))='--','',concat('--',extractvalue(metadata,'//datafield[@tag=\\\"651\\\"]/ subfield[@code=\\\"z\\\"]')))),'|','') as subject,"							
			+ " extractvalue(bm.metadata, '//datafield[@tag=\"505\"]/subfield[@code=\"a\"]') as content,"
			+ " extractvalue(bm.metadata, '//datafield[@tag=\"520\"]/subfield[@code=\"a\"]') as summary,"
			+ " extractvalue(bm.metadata, '//datafield[@tag=\"300\"]/subfield[@code=\"a\" or @code=\"b\" or @code=\"c\"]') as description,"
			+ " bi.notes as bi_notes, b.timestamp as b_timestamp, b.datecreated, b.serial, b.biblionumber, REPLACE(Replace(bi.isbn,' ',''),'-','') as isbn, bi.itemtype, bi.collectiontitle,"
			+ " bi.biblioitemnumber, bm.id as bm_id, bm.format as bm_format, bm.schema as bm_schema,"
			+ " bm.metadata as bm_metadata, bm.timestamp as bm_timestamp";
	
	String BIBLIOQUERY = BIBLIOSELECT
			+ " from biblio b left outer join biblioitems bi on bi.biblionumber = b.biblionumber left outer join biblio_metadata bm on bm.biblionumber = b.biblionumber";
	String BIBLIOITEMSELECT = BIBLIOSELECT
			+ ", i.itemnumber, i.booksellerid, i.homebranch, i.itemcallnumber, i.barcode, i.enumchron, i.timestamp as i_timestamp, i.itype, se.publisheddate, av.lib as collection";
	String BIBLIOITEMQUERY = BIBLIOITEMSELECT
			+ " from biblio b left outer join items i on i.biblionumber = b.biblionumber left outer join biblioitems bi on bi.biblionumber = i.biblionumber left outer join biblio_metadata bm on bm.biblionumber = b.biblionumber left outer join serialitems si on si.itemnumber = i.itemnumber left outer join serial se on se.serialId = si.serialId left outer join authorised_values av on av.authorised_value = i.ccode and av.category = 'ccode'";

	public List<SyncData> getBiblioItems(int itemNumber) {
		String sql = BIBLIOITEMQUERY + " where i.itype like 'eres_%' and i.itemnumber > " + itemNumber;
		List<SyncData> sync_list = this.template.query(sql, (rs, rowNum) -> buildSyncData(rs));
		return sync_list;
	}

	private SyncData buildSyncData(ResultSet rs) {
		try {
			return new SyncData(rs.getString("title"), rs.getString("author"), rs.getString("b_notes"),
					rs.getString("b_timestamp"), rs.getString("datecreated"), rs.getInt("serial"),
					rs.getInt("biblionumber"), rs.getInt("itemnumber"), rs.getString("booksellerid"),
					rs.getString("homebranch"), rs.getString("itemcallnumber"), rs.getString("barcode"),
					rs.getString("enumchron"), rs.getString("i_timestamp"), rs.getString("isbn"),
					rs.getString("publicationyear"), rs.getString("publishercode"), rs.getString("itemtype"),
					rs.getString("collectiontitle"), rs.getInt("biblioitemnumber"), rs.getString("editionstatement"),
					rs.getString("place"), rs.getString("bi_notes"), rs.getInt("bm_id"), rs.getString("bm_format"),
					rs.getString("bm_schema"), rs.getString("bm_metadata"), rs.getString("bm_timestamp"),
					rs.getString("itype"), rs.getString("subject"), rs.getString("content"), rs.getString("summary"),
					rs.getDate("publisheddate"), rs.getString("collection"), rs.getString("coauthor"),rs.getString("description"));
		} catch (SQLException e) {
			e.printStackTrace();
			return new SyncData();
		}
	}

	public List<SyncData> getBiblioItemsByList(List<Integer> itemList) {
		String inSql = String.join(",", Collections.nCopies(itemList.size(), "?"));
		String query = String.format(BIBLIOITEMQUERY + " where i.itemnumber in (%s) and i.itype like 'eres_%%'", inSql);
		List<SyncData> syncDataList = this.template.query(query, itemList.toArray(), (rs, rowNum) -> buildSyncData(rs));
		return syncDataList;
	}

	@Override
	public List<SyncData> getBiblioWithItemsByBibioNumber(List<Integer> bNumbers) {
		String inSql = String.join(",", Collections.nCopies(bNumbers.size(), "?"));
		String query = String.format(BIBLIOITEMQUERY + " where b.biblionumber in (%s) and i.itype like 'eres_%%'", inSql);
		List<SyncData> syncDataList = this.template.query(query, bNumbers.toArray(), (rs, rowNum) -> buildSyncData(rs));
		return syncDataList;
	}

	@Override
	public List<SyncData> getBiblioDetailByBibioNumber(List<Integer> bNumbers) {
		String inSql = String.join(",", Collections.nCopies(bNumbers.size(), "?"));
		String query = String.format(BIBLIOQUERY + " where b.biblionumber in (%s)", inSql);
		List<SyncData> syncDataList = this.template.query(query, bNumbers.toArray(),
				(rs, rowNum) -> new SyncData(rs.getString("title"), rs.getString("author"), rs.getString("b_notes"),
						rs.getString("b_timestamp"), rs.getString("datecreated"), rs.getInt("serial"),
						rs.getInt("biblionumber"), 0, null, null, null, null, null, null, rs.getString("isbn"),
						rs.getString("publicationyear"), rs.getString("publishercode"), rs.getString("itemtype"),
						rs.getString("collectiontitle"), rs.getInt("biblioitemnumber"),
						rs.getString("editionstatement"), rs.getString("place"), rs.getString("bi_notes"),
						rs.getInt("bm_id"), rs.getString("bm_format"), rs.getString("bm_schema"),
						rs.getString("bm_metadata"), rs.getString("bm_timestamp"), null, rs.getString("subject"), rs.getString("content"), rs.getString("summary"), null, null, rs.getString("coauthor"),rs.getString("description")));
		return syncDataList;
	}

	@Override
	public int getBiblioItemCount(int itemnumber) {
		List<Integer> countList = this.template.query(
				"select count(itemnumber) as count from items where itype like 'eres_%' and itemnumber > " + itemnumber,
				(rs, rowNum) -> rs.getInt("count"));
		return countList.size() > 0 ? countList.get(0) : 0;
	}

	@Override
	public List<ItemTypes> getItemTypes() {
		List<ItemTypes> itemList = this.template.query("SELECT description, itemtype FROM itemtypes",
				(rs, rowNum) -> new ItemTypes(0, rs.getString(1), rs.getString(2)));
		return itemList;
	}

	@Override
	public List<Patron> getNewPatronList(Patron lastPatron) {
		String sql = "SELECT b.borrowernumber, b.cardnumber, b.userid, b.password, b.updated_on, b.email, b.surname, b.title, b.dateofbirth, b.city, c.description as category FROM borrowers b left outer join categories c on b.categorycode = c.categorycode";
		if(lastPatron.getUpdated_on() != null && lastPatron.getUpdated_on() != "") 
		{
			sql = String.format("%s where updated_on > '%s'", sql, lastPatron.getUpdated_on());
		}
		return this.template.query(sql,
				(rs, rowNum) -> new Patron(rs.getInt("borrowernumber"), rs.getString("cardnumber"),
						rs.getString("userid"), rs.getString("password"), rs.getString("updated_on"), rs.getString("email"), rs.getString("surname"), rs.getString("title"), rs.getDate("dateofbirth"), rs.getString("city"), rs.getString("category")));
	}
}
