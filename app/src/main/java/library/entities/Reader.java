package library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "phone")
    private String phone;

    
    //POJO
    public Reader() {
    }
    public Reader(Integer id, String fullName, String passportNumber, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.passportNumber = passportNumber;
        this.phone = phone;
    }
    public Reader(String fullName, String passportNumber, String phone) {
        this.fullName = fullName;
        this.passportNumber = passportNumber;
        this.phone = phone;
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
    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
