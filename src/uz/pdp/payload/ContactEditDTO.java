package uz.pdp.payload;

public class ContactEditDTO {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private Long userId;

    public ContactEditDTO() {
    }

    public ContactEditDTO(Long id, String fullName, String phone, String email, Long userId) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
