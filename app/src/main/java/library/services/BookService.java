package library.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import jakarta.transaction.Transactional;
import library.entities.Book;
import library.repositories.BookRepository;

@Service
@Transactional
public class BookService {

    private final BookRepository repository;


    public Book getBook(int id) throws Exception{
        Optional<Book> book = repository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
    }

    public Boolean getStatus(int id){
        return repository.getStatus(id);
    }

    public void setStatusFalse(int id){
        if(repository.getStatus(id)){
            repository.setStatusFalse(id);
        }
    }

    public void setStatusTrue(int id){
        if(!repository.getStatus(id)){
            repository.setStatusTrue(id);
        }
    }
    
    public void addBook(Book book){
        repository.save(book);
    }

    public Page<Book> getBooks(Integer numPage){
        return repository.findAll(PageRequest.of(numPage, 10, Sort.by("id").ascending()));
    }

    //Constructor
    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }
}
