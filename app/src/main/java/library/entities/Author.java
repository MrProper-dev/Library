package library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "country")
    private String country;

    
    //POJO
    public Author() {
    }
    public Author(Integer id, String fullName, Integer birthYear, String country) {
        this.id = id;
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.country = country;
    }
    public Author(String fullName, Integer birthYear, String country) {
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.country = country;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Integer getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }    
}
