package de.codecentric.psd.worblehat.web.formcheck;

public class ISBNTrimmer {

	public ISBNTrimmer() {
		super();
	}

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
