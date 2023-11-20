package beans;
public class Book {
    private String title;
    private String author;
    private String collection;
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
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public Book(String title, String author, String collection) {
		super();
		this.title = title;
		this.author = author;
		this.collection = collection;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and setters
    
}
