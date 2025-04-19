package library.dto;

public class ReaderGetDto {

    private String fullName;

    private String passportNumber;

    private String phone;

    
    //POJO
    public ReaderGetDto() {
    }
    public ReaderGetDto(String fullName, String passportNumber, String phone) {
        this.fullName = fullName;
        this.passportNumber = passportNumber;
        this.phone = phone;
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
