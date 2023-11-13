package classes.users;

public class Author extends BaseUser{
    private String phone;
    private String document;
    
    public Author(String name, String email, String password, String phone, String document) {
        super(name, email, password);
        this.phone = phone;
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
    
}
