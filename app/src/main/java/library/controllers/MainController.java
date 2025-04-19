package library.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import library.dto.BookViewDto;
import library.entities.Book;
import library.entities.LoanedBook;
import library.mappers.BookMapper;
import library.services.BookService;
import library.services.LoanedBookService;

@Controller
public class MainController {

    private final BookService bookService;
    private final BookMapper bookViewMapper;
    private final LoanedBookService loanedBookService;

    @GetMapping("/library")
    public String getMainPage(){
        return "main_page.html";
    }
    
    @GetMapping("/addbook")
    public String getAddBookPage(){
        return "add_book_page.html";
    }

    @GetMapping("/loanbook/{id}")
    public String getLoanBookPage(Model model, @PathVariable("id") int id) throws Exception{
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "loan_book_page.html";
    }

    @GetMapping("/booksreport")
    public String getBooksReport(Model model, @RequestParam("numPage") Integer numPage){
        Page<Book> page = bookService.getBooks(numPage);
        List<BookViewDto> booksOnPage = page.getContent()
                                            .stream()
                                            .map(book -> bookViewMapper.map(book))
                                            .toList();
        model.addAttribute("books", booksOnPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("currentPage", numPage);
        return "books_report_page.html";
    }

    @GetMapping("/loanedbookreport")
    public String getLoanedBooksReport(Model model, @RequestParam("numPage") Integer numPage){
        Page<LoanedBook> page = loanedBookService.getBooks(numPage);
        List<LoanedBook> booksOnPage = page.toList();
        model.addAttribute("books", booksOnPage);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("currentPage", numPage);
        return "loaned_books_report_page.html";
    }

    //Constructor
    public MainController(BookService bookService, BookMapper bookViewMapper, LoanedBookService loanedBookService) {
        this.bookService = bookService;
        this.bookViewMapper = bookViewMapper;
        this.loanedBookService = loanedBookService;
    }
}
