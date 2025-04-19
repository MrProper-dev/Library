package library.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.services.BookService;
import library.services.ImageService;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {

    private final BookService bookService;
    private final ImageService imageService;

    @GetMapping("/status/{id}")
    public Boolean getStatus(@PathVariable("id") Integer id){
        return bookService.getStatus(id);
    }
    
    @GetMapping(value = "/image/{id}",  produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("id") Integer id){
        return imageService.getImage(id);
    }

    //Constructor 
    public BookRestController(BookService bookService, ImageService imageService) {
        this.bookService = bookService;
        this.imageService = imageService;
    }
}
