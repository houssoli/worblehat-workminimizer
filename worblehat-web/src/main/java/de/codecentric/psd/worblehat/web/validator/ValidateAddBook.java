package de.codecentric.psd.worblehat.web.validator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.ISBNValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.codecentric.psd.worblehat.web.command.BookDataFormData;

/**
 * Validation for adding a book
 * 
 * @author mahmut.can
 * 
 */
public class ValidateAddBook implements Validator {

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
			ISBNValidator isbnValidator = new ISBNValidator();
			if (!isbnValidator.isValid(cmd.getIsbn())) {
				errors.rejectValue("isbn", "notvalid");
			}

		}
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
