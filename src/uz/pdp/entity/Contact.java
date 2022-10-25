package uz.pdp.entity;

public class Contact {
private static long counter=0L;
    {
        counter++;
        id=counter;
    }
    private Long id;
    private String fullname;
    private String phone;
    private String email;
    private String company;
    private String position;
    private String birthDate;
    private String description;
    private String address;
    private Long userId;

    public Contact(String firstname,String phone) {
        this.fullname=firstname;
        this.phone=phone;
    }

    public Contact(String firstname, String phone, String email, String company, String position, String birthDate, String description, String address) {
        this.fullname = firstname;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.position = position;
        this.birthDate = birthDate;
        this.description = description;
        this.address = address;
    }

    public Contact(String firstname, String phone, String email, String company, String position, String birthDate, String description, String address, Long userId) {
        this.fullname = firstname;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.position = position;
        this.birthDate = birthDate;
        this.description = description;
        this.address = address;
        this.userId = userId;
    }

    public Contact() {

    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        Contact.counter = counter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                '}';
    }
}
