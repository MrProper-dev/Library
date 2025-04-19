package library.dto;

import java.time.LocalDate;

import library.entities.Author;
import library.entities.Publisher;

public class BookViewDto {

    private Integer id;

    private String title;

    private Author author;

    private Integer publicationYear;

    private String genre;

    private Publisher publisher;

    private String description;

    private String image;

    private String loanStatus;

    private LocalDate addedDate;

    //POJO
    public BookViewDto() {
    }
    public BookViewDto(Integer id, String title, Author author, Integer publicationYear, String genre, Publisher publisher,
            String description, String image, String loanStatus, LocalDate addedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.publisher = publisher;
        this.description = description;
        this.image = image;
        this.loanStatus = loanStatus;
        this.addedDate = addedDate;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Integer getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getLoanStatus() {
        return loanStatus;
    }
    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
    public LocalDate getAddedDate() {
        return addedDate;
    }
    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
}
