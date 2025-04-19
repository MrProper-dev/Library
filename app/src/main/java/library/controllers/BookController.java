package library.controllers;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import library.dto.BookViewDto;
import library.dto.ReaderGetDto;
import library.entities.Author;
import library.entities.Book;
import library.entities.Publisher;
import library.mappers.BookMapper;
import library.services.BookService;
import library.services.ImageService;
import library.services.LoanedBookService;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final ImageService imgService;
    private final BookMapper bookViewMapper;
    private final LoanedBookService loanedBookService;

    @GetMapping("/{id}")
    public String getBookPage(Model model, @PathVariable("id") int id) throws Exception{
        Book book = bookService.getBook(id);
        BookViewDto viewBook = bookViewMapper.map(book);
        model.addAttribute("book", viewBook);
        return "book_page.html";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam("title") String title,
                          @RequestParam("author-name") String authorName,
                          @RequestParam("author-birth-year") Integer authorBirthYear,
                          @RequestParam("author-country") String authorCountry,
                          @RequestParam("publisher-name") String publisherName,
                          @RequestParam("publisher-address") String publisherAdderess,
                          @RequestParam("genre") String genre,
                          @RequestParam("publication-year") Integer publicationYear,
                          @RequestParam("description") String description,
                          @RequestParam("image") MultipartFile image) throws IOException{

        Author author = new Author(authorName, authorBirthYear, authorCountry);
        Publisher publisher = new Publisher(publisherName, publisherAdderess);
        
        String fileName = imgService.saveImage(image, title, authorName);

        Book book = new Book(title, author, publicationYear, genre, publisher, description, "/img/" + fileName, LocalDate.now());
        bookService.addBook(book);

        return "redirect:/library";
    }

    @PostMapping("/loan/{id}")
    @Transactional
    public String loanBook(@PathVariable("id") int id, ReaderGetDto reader, @RequestParam("returnDate") LocalDate returnDate){
        bookService.setStatusFalse(id);
        loanedBookService.addLoanedBook(id, reader, returnDate);
        return "redirect:/library";
    }

    @PostMapping("/return/{id}")
    @Transactional
    public String returnBook(@PathVariable("id") int id){
        bookService.setStatusTrue(id);
        loanedBookService.deleteLoanedBook(id);
        return "redirect:/library";
    }


    //Constructor
    public BookController(BookService bookService, ImageService imageService, BookMapper bookViewMapper, LoanedBookService loanedBookService) {
        this.bookService = bookService;
        this.imgService = imageService;
        this.bookViewMapper = bookViewMapper;
        this.loanedBookService = loanedBookService;
    }
}
