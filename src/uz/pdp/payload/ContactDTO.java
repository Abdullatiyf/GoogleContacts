package uz.pdp.payload;

public class ContactDTO {
    private String fullName;
    private String phone;
    private String email;
    private String company;
    private String position;
    private String birthDate;
    private String description;
    private String address;
    private Long userId;

    public ContactDTO() {
    }

    public ContactDTO(String fullName, String phone, String email, String company, String position, String birthDate, String description, String address) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.position = position;
        this.birthDate = birthDate;
        this.description = description;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
