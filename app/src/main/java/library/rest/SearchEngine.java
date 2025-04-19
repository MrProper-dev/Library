package library.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import library.dto.SearchBook;
import library.services.SearchService;

@RestController
@RequestMapping("/api/v1/search")
public class SearchEngine {

    private final SearchService searchService;

    @GetMapping
    public List<SearchBook> findByAuthorNameOrBookTitle(@RequestParam("query") String query){
        return searchService.searchBooks(query).stream().map(book -> new SearchBook(
                                                  book.getId(),
                                                  book.getTitle(), 
                                                  book.getAuthor().getFullName(),
                                                  book.getPublicationYear())).toList();
    }

    //Constructor
    public SearchEngine(SearchService searchService) {
        this.searchService = searchService;
    }
}
