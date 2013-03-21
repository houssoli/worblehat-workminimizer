package de.codecentric.psd.worblehat.web.validator;

import org.apache.commons.validator.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.codecentric.psd.worblehat.web.command.ShowBorrowedBooksFormData;

/**
 * 
 * Validates email address when borrowed books shall be shown.
 * 
 * @author psd
 * 
 */
public class ValidateShowBorrowedBooks implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ShowBorrowedBooksFormData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (!supports(target.getClass())) {
			throw new IllegalArgumentException(
					"Not supported FormData for this validator: "
							+ target.getClass());
		}
		ShowBorrowedBooksFormData cmd = (ShowBorrowedBooksFormData) target;
		checkThatUserEmailAddressIsFilledAndValid(errors, cmd);

	}

	private void checkThatUserEmailAddressIsFilledAndValid(Errors errors,
			ShowBorrowedBooksFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress",
				"empty");
		if (!errors.hasFieldErrors("emailAddress")) {
			if (!EmailValidator.getInstance().isValid(cmd.getEmailAddress())) {
				errors.rejectValue("emailAddress", "notvalid");
			}
		}
	}

}
