package library.dto;

public class SearchBook {

    private Integer id;

    private String title;
    
    private String authorName;

    private Integer publicationYear;


    //POJO    
    public SearchBook() {
    }
    public SearchBook(Integer id, String title, String authorName, Integer publicationYear) {
        this.title = title;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
        this.id = id;
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
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public Integer getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
}
