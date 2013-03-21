package de.codecentric.psd.worblehat.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookRepository;
import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.command.ShowBorrowedBooksFormData;
import de.codecentric.psd.worblehat.web.validator.ValidateShowBorrowedBooks;

/**
 * Controller class for the
 * 
 * @author psd
 * 
 */
@Controller
@RequestMapping("/showBorrowedBooks")
public class ShowBorrowedBooksController {

	ValidateShowBorrowedBooks validateShowBorrowedBooks = new ValidateShowBorrowedBooks();

	@Inject
	private BookRepository bookRepository;
	@Inject
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public void prepareView(ModelMap modelMap) {
		modelMap.put("showBorrowedBooksFormData",
				new ShowBorrowedBooksFormData());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String showBorrowedBooks(
			ModelMap modelMap,
			@ModelAttribute("showBorrowedBooksFormData") ShowBorrowedBooksFormData formData,
			BindingResult result) {
		validateShowBorrowedBooks.validate(formData, result);
		if (result.hasErrors()) {
			return "/showBorrowedBooks";
		} else {
			List<Book> books = bookRepository.findAllBorrowedBooksByBorrower();
			modelMap.addAttribute("books", books);
			return "bookList";
			bookService.showBorrowedBooks(formData.getEmailAddress());
			return "/home";
		}
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
