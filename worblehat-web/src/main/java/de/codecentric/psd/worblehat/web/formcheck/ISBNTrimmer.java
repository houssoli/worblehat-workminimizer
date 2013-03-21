package de.codecentric.psd.worblehat.web.formcheck;

/**
 * ISBNTrimmer entfernt Leerzeichen und Bindestriche in einer ISBN.
 * 
 * @author asf8
 * 
 */
public class ISBNTrimmer {

	/**
	 * Default Constructor.
	 */
	public ISBNTrimmer() {
		super();
	}

	/**
	 * Entfernt aus einem uebergebenem String Leerzeichen und Bindestriche
	 * 
	 * @param isbn
	 *            zu trimmende ISBN
	 * @return getrimmte ISBN
	 */
	public String trimISBN(String isbn) {
		String trimmedISBN = isbn;
		// Entferne Leerzeichen am Ende
		trimmedISBN = trimmedISBN.trim();

		// Entferne Bindestriche
		trimmedISBN = trimmedISBN.replace("-", "");

		// Entferne Leerzeichen in der Mitte
		trimmedISBN = trimmedISBN.replace(" ", "");

		return trimmedISBN;

	}

}
