package library.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name =  "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @OneToOne(fetch = FetchType.EAGER,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name =  "genre")
    private String genre;

    @OneToOne(fetch = FetchType.EAGER,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "loan_status")
    private Boolean loanStatus = true;

    @Column(name = "added_date")
    private LocalDate addedDate;


    //POJO
    public Book() {
    }
    public Book(Integer id, String title, Author author, Integer publicationYear, String genre, Publisher publisher,
            String description, String image, Boolean loanStatus, LocalDate addedDate) {
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
    public Book(String title, Author author, Integer publicationYear, String genre, Publisher publisher,
            String description, String image, LocalDate addedDate) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.publisher = publisher;
        this.description = description;
        this.image = image;
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
    public Boolean getLoanStatus() {
        return loanStatus;
    }
    public void setLoanStatus(Boolean loanStatus) {
        this.loanStatus = loanStatus;
    }
    public LocalDate getAddedDate() {
        return addedDate;
    }
    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
}
