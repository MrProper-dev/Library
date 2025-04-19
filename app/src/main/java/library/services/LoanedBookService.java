package library.services;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import library.dto.ReaderGetDto;
import library.entities.Book;
import library.entities.LoanedBook;
import library.mappers.ReaderMapper;
import library.repositories.BookRepository;
import library.repositories.LoanedBookRepository;

@Service
public class LoanedBookService {

    private final LoanedBookRepository loanedBookRepository;
    private final BookRepository bookRepository;
    private final ReaderMapper readerMapper;

    public Page<LoanedBook> getBooks(Integer numPage){
        return loanedBookRepository.findAll(PageRequest.of(numPage, 10, Sort.by("id").ascending()));
    }

    @Transactional
    public void addLoanedBook(int id, ReaderGetDto reader, LocalDate returnDate){
        Book book = bookRepository.findById(id).get();
        LoanedBook loanedBook = new LoanedBook(
                                    book,
                                    readerMapper.map(reader),
                                    LocalDate.now(),
                                    returnDate
        );
        loanedBookRepository.save(loanedBook);
    }

    public void deleteLoanedBook(int id){
        loanedBookRepository.deleteByBookId(id);
    }

    //Constructor
    public LoanedBookService(LoanedBookRepository loanedBookRepository, BookRepository bookRepository, ReaderMapper readerMapper) {
        this.loanedBookRepository = loanedBookRepository;
        this.bookRepository = bookRepository;
        this.readerMapper = readerMapper;
    }
}
