package de.codecentric.psd.worblehat.web.command;

/**
 * @author mahmut.can
 * 
 */
public class BookDataFormData {

	private String title;
	private String edition;
	private String year;
	private String isbn;
	private String author;
	private String description;
	private String isbn13;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		this.description = d;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "BookDataFormData [title=" + title + ", edition=" + edition
				+ ", year=" + year + ", isbn=" + isbn + ", author=" + author
				+ "]";
	}

}
