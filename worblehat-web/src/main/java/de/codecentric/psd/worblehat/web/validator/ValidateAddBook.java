package de.codecentric.psd.worblehat.web.validator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.ISBNValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.codecentric.psd.worblehat.web.command.BookDataFormData;
import de.codecentric.psd.worblehat.web.formcheck.ISBNTrimmer;

/**
 * Validation for adding a book
 * 
 * @author mahmut.can
 * 
 */
public class ValidateAddBook implements Validator {

	private ISBNTrimmer isbnTrimmer = new ISBNTrimmer();

	@Override
	public boolean supports(Class<?> clazz) {
		return BookDataFormData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (!supports(target.getClass()))
			throw new IllegalArgumentException("Validation of classs '"
					+ target.getClass() + "' is not supported");

		BookDataFormData cmd = (BookDataFormData) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "empty");

		checkThatYearIsFilledAndValid(errors, cmd);
		checkThatIsbnIsFilledAndValid(errors, cmd);
		checkThatEditionisFilledAndValid(errors, cmd);
		checkThatDescriptionIsFilledAndValid(errors, cmd);

	}

	private void checkThatDescriptionIsFilledAndValid(Errors errors,
			BookDataFormData cmd) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"empty");
		if (!errors.hasFieldErrors("description")) {
			if (cmd.getDescription().length() > 2999) {
				errors.rejectValue("description", "notvalid");
			}
		}

	}

	private void checkThatEditionisFilledAndValid(Errors errors,
			BookDataFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edition", "empty");
		if (!errors.hasFieldErrors("edition")) {
			if (!StringUtils.isNumeric(cmd.getEdition())) {
				errors.rejectValue("edition", "notvalid");
			}
		}
	}

	private void checkThatIsbnIsFilledAndValid(Errors errors,
			BookDataFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "empty");
		if (!errors.hasFieldErrors("isbn")) {
			cmd.setIsbn(isbnTrimmer.trimISBN(cmd.getIsbn()));
			ISBNValidator isbnValidator = new ISBNValidator();
			String isbn = "";
			if (cmd.getIsbn().length() > 10) {
				isbn = ConvertISBN13To10(cmd.getIsbn());
				cmd.setIsbn13(isbn);
			} /*
			 * else { isbn = cmd.getIsbn(); }
			 */

			if (!(isbnValidator.isValid(cmd.getIsbn()) || isbnValidator
					.isValid(cmd.getIsbn13()))) {
				errors.rejectValue("isbn", "notvalid");
			}

		}
	}

	private static String ConvertISBN13To10(String isbn) {
		char[] isbn13 = new char[13];
		int[] isbn10 = new int[10];
		StringBuilder sb;
		int checksum;

		isbn13 = isbn.toCharArray();

		for (int i = 3, j = 0; i < 12; i++, j++) {
			isbn10[j] = Character.getNumericValue(isbn13[i]);// Integer.parseInt(isbn13[i]
																// + "");
		}
		checksum = 0;
		sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			checksum += isbn10[i] * (i + 1);
			sb.append(isbn10[i] + "");
		}
		checksum %= 11;
		if (checksum == 10) {
			sb.append("X");
		} else {
			sb.append(checksum + "");
		}
		return (sb.toString());
	}

	private void checkThatYearIsFilledAndValid(Errors errors,
			BookDataFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "empty");
		if (!errors.hasFieldErrors("year")) {
			if (!StringUtils.isNumeric(cmd.getYear())) {
				errors.rejectValue("year", "notvalid");
			} else if (StringUtils.length(cmd.getYear()) != 4) {
				errors.rejectValue("year", "invalid.length");
			}
		}
	}

}
