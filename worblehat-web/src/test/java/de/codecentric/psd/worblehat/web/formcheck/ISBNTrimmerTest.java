package de.codecentric.psd.worblehat.web.formcheck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ISBNTrimmerTest {

	@Test
	public void shouldTrimISBN() {

		ISBNTrimmer isbnTrimmer = new ISBNTrimmer();
		String isbn = "123-123 1231 ";
		assertEquals(isbnTrimmer.trimISBN(isbn), "1231231231");
	}
}
