package models.classes;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private int id;
    private String title;
    private List<Integer> subareasId;
    
    public Area(int id, String title) {
        this.id = id;
        this.title = title;
        this.subareasId = new ArrayList<Integer>();
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

    public List<Integer> getSubareasId() {
        return subareasId;
    }

    public void setSubareasId(List<Integer> subareasId) {
        this.subareasId = subareasId;
    }
    
}