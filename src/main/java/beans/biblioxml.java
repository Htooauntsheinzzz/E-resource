package beans;

public class biblioxml {

	    private String title_capital;
	    private String title_small;
	    private String publication_place;
	    private String publication_name;
	    private int publication_date;
	    private String page;
	    private String image;
	    private String coauthor1;
	    private String coauthor2;
	    private String coauthor3;
	    private String coauthor4;
		public String getTitle_capital() {
			return title_capital;
		}
		public void setTitle_capital(String title_capital) {
			this.title_capital = title_capital;
		}
		public String getTitle_small() {
			return title_small;
		}
		public void setTitle_small(String title_small) {
			this.title_small = title_small;
		}
		public String getPublication_place() {
			return publication_place;
		}
		public void setPublication_place(String publication_place) {
			this.publication_place = publication_place;
		}
		public String getPublication_name() {
			return publication_name;
		}
		public void setPublication_name(String publication_name) {
			this.publication_name = publication_name;
		}
		public int getPublication_date() {
			return publication_date;
		}
		public void setPublication_date(int publication_date) {
			this.publication_date = publication_date;
		}
		public String getPage() {
			return page;
		}
		public void setPage(String page) {
			this.page = page;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getCoauthor1() {
			return coauthor1;
		}
		public void setCoauthor1(String coauthor1) {
			this.coauthor1 = coauthor1;
		}
		public String getCoauthor2() {
			return coauthor2;
		}
		public void setCoauthor2(String coauthor2) {
			this.coauthor2 = coauthor2;
		}
		public String getCoauthor3() {
			return coauthor3;
		}
		public void setCoauthor3(String coauthor3) {
			this.coauthor3 = coauthor3;
		}
		public String getCoauthor4() {
			return coauthor4;
		}
		public void setCoauthor4(String coauthor4) {
			this.coauthor4 = coauthor4;
		}
		public biblioxml(String title_capital, String title_small, String publication_place, String publication_name,
				int publication_date, String page, String image, String coauthor1, String coauthor2, String coauthor3,
				String coauthor4) {
			super();
			this.title_capital = title_capital;
			this.title_small = title_small;
			this.publication_place = publication_place;
			this.publication_name = publication_name;
			this.publication_date = publication_date;
			this.page = page;
			this.image = image;
			this.coauthor1 = coauthor1;
			this.coauthor2 = coauthor2;
			this.coauthor3 = coauthor3;
			this.coauthor4 = coauthor4;
		}
		public biblioxml() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

	    
	    // Getters and setters for the fields
	    // ...
	

}
