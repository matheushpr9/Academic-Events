package models.users;

public class Revisor extends BaseUser{
    private String phone;
    private String document;// cpf for brazilian and rne foe foreign
    private String lattes;
    private String workingInstitution;
    private String researchId;

    public Revisor(String name, String email, String password, String phone, String document, String lattes,
            String workingInstitution, String researchId) {
        super(name, email, password);
        this.phone = phone;
        this.document = document;
        this.lattes = lattes;
        this.workingInstitution = workingInstitution;
        this.researchId = researchId;
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

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public String getWorkingInstitution() {
        return workingInstitution;
    }

    public void setWorkingInstitution(String workingInstitution) {
        this.workingInstitution = workingInstitution;
    }

    public String getResearchId() {
        return researchId;
    }

    public void setResearchId(String researchId) {
        this.researchId = researchId;
    }

}
