package classes;

public class SubArea {
    private Integer id;
    private String title;
    private Integer areaId;

    public SubArea(Integer id, String title, Integer areaId) {
        this.id = id;
        this.title = title;
        this.areaId = areaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

}
