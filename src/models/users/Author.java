package models.users;

public class Author extends BaseUser{
    private String phone;
    private String authorDocument;
    
    public Author(String name, String email, String password, String phone, String authorDocument) {
        super(name, email, password);
        this.phone = phone;
        this.authorDocument = authorDocument;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthorDocument() {
        return authorDocument;
    }

    public void setAuthorDocument(String authorDocument) {
        this.authorDocument = authorDocument;
    }
    
}
