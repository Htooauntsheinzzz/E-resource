package beans;

public class biblio {
	private int id;
	private String title;
	private String author;
	private String coauthor1;
	private String coauthor2;
	private String coauthor3;
	private String coauthor4;
	private String collection;
	private int publicationyear;
	private String publishercode;
	private String place;
	private String subject1;
	private String subject2;
	private String subject3;
	private String subject4;
	private String editionstatement;
	private String content;
	private String Summary;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public int getPublicationyear() {
		return publicationyear;
	}
	public void setPublicationyear(int publicationyear) {
		this.publicationyear = publicationyear;
	}
	public String getPublishercode() {
		return publishercode;
	}
	public void setPublishercode(String publishercode) {
		this.publishercode = publishercode;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getSubject1() {
		return subject1;
	}
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	public String getSubject3() {
		return subject3;
	}
	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}
	public String getSubject4() {
		return subject4;
	}
	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}
	public String getEditionstatement() {
		return editionstatement;
	}
	public void setEditionstatement(String editionstatement) {
		this.editionstatement = editionstatement;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public biblio(int id, String title, String author, String coauthor1, String coauthor2, String coauthor3,
			String coauthor4, String collection, int publicationyear, String publishercode, String place,
			String subject1, String subject2, String subject3, String subject4, String editionstatement, String content,
			String summary, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.coauthor1 = coauthor1;
		this.coauthor2 = coauthor2;
		this.coauthor3 = coauthor3;
		this.coauthor4 = coauthor4;
		this.collection = collection;
		this.publicationyear = publicationyear;
		this.publishercode = publishercode;
		this.place = place;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.editionstatement = editionstatement;
		this.content = content;
		Summary = summary;
		this.description = description;
	}
	public biblio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
