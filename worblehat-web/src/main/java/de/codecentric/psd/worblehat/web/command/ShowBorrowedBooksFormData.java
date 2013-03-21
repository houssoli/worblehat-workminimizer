package de.codecentric.psd.worblehat.web.command;

/**
 * This class represent the form data of the borrowed book form.
 * 
 * @author psd
 * 
 */
public class ShowBorrowedBooksFormData {

	private String emailAdress;

	/**
	 * Default constructor.
	 */
	public ShowBorrowedBooksFormData() {
		super();
	}

	public String getEmail() {
		return emailAdress;
	}

	public void setEmail(String email) {
		this.emailAdress = email;
	}

}
