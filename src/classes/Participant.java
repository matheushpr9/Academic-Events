package classes;

public class Participant {
    private String name;
    private String email;
    private String qrCode;

    public Participant(String name, String email, String qrCode, String type) {
        this.name = name;
        this.email = email;
        this.qrCode = qrCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getqrCode() {
        return qrCode;
    }
    public void setqrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    
}