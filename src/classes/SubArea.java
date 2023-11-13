package classes;

public class SubArea {
    private int id;
    private String title;
    private int areaId;

    public SubArea(int id, String title, int areaId) {
        this.id = id;
        this.title = title;
        this.areaId = areaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

}
