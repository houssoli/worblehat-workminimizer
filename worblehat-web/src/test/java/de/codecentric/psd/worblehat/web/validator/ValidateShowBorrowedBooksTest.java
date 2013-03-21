package de.codecentric.psd.worblehat.web.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import de.codecentric.psd.worblehat.web.command.ShowBorrowedBooksFormData;

public class ValidateShowBorrowedBooksTest {

	private static final String VALID_EMAIL = "valid.user@worblehat.local";
	private ValidateShowBorrowedBooks validateShowBorrowedBooks;
	private ShowBorrowedBooksFormData cmd;

	@Before
	public void setUp() {
		validateShowBorrowedBooks = new ValidateShowBorrowedBooks();
		cmd = new ShowBorrowedBooksFormData(VALID_EMAIL);
	}

	@Test
	public void shouldWorkForThisValidator() {
		boolean supports = validateShowBorrowedBooks
				.supports(ShowBorrowedBooksFormData.class);
		assertTrue(supports);
	}

	@Test
	public void shouldValidateValidEmail() {
		Errors errors = new BindException(cmd, "showBorrowedBooksFormData");
		validateShowBorrowedBooks.validate(cmd, errors);
		Assert.assertEquals(0, errors.getErrorCount());
	}

	@Test
	public void shouldFailOnEmptyEmail() {
		Errors errors = new BindException(cmd, "showBorrowedBooksFormData");
		cmd.setEmailAddress(" ");
		validateShowBorrowedBooks.validate(cmd, errors);
		Assert.assertEquals(1, errors.getErrorCount());
		String code = errors.getFieldError("emailAddress").getCode();
		assertEquals("empty", code);
	}

	@Test
	public void shouldFailOnInvalidEmail() {
		Errors errors = new BindException(cmd, "showBorrowedBooksFormData");
		cmd.setEmailAddress("aa.de");
		validateShowBorrowedBooks.validate(cmd, errors);
		Assert.assertEquals(1, errors.getErrorCount());
		String code = errors.getFieldError("emailAddress").getCode();
		assertEquals("notvalid", code);
	}

}
