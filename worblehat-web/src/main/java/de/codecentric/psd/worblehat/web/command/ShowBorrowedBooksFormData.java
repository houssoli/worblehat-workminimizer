package de.codecentric.psd.worblehat.web.command;

/**
 * This class represent the form data of the borrowed book form.
 * 
 * @author psd
 * 
 */
public class ShowBorrowedBooksFormData {

	private String emailAddress;

	/**
	 * Default constructor.
	 */
	public ShowBorrowedBooksFormData() {
		super();
	}

	/**
	 * @param emailAddress
	 *            the user email address
	 */
	public ShowBorrowedBooksFormData(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}

}
