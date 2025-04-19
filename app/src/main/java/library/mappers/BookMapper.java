package library.mappers;

import org.springframework.stereotype.Component;

import library.dto.BookViewDto;
import library.entities.Book;

@Component
public class BookMapper {

        public BookViewDto map(Book book){
            String loanStatus;
            if(book.getLoanStatus()){
                loanStatus = "Доступна для выдачи";
            }else{
                loanStatus = "Не доступна для выдачи";
            }
            return new BookViewDto(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublicationYear(),
                        book.getGenre(),
                        book.getPublisher(),
                        book.getDescription(),
                        book.getImage(),
                        loanStatus,
                        book.getAddedDate()
            );
        }

}