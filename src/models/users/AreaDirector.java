package models.users;

public class AreaDirector {
    private String phone;
    private String documentNumber;
    private int areaId;
    
    public AreaDirector(String phone, String documentNumber, int areaId) {
        this.phone = phone;
        this.documentNumber = documentNumber;
        this.areaId = areaId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    
}
