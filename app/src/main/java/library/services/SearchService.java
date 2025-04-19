package library.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import library.entities.Book;
import library.repositories.BookRepository;

@Service
public class SearchService {

    private final BookRepository bookRepository;

    public List<Book> searchBooks(String query){
        return bookRepository.findByTitleAndAuthorName(query, 
        PageRequest.of(0, 5, 
        Sort.by("title")))
        .toList();
    }

    //Constructor
    public SearchService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
