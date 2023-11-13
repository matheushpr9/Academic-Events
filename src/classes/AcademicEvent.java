package classes;

import java.util.List;

public class AcademicEvent {
    private int uuid;
    private String name;
    private String initDate;
    private String endDate;
    private String location;
    private String theme;
    private String description;
    private int areaDirectorId;
    private List<Integer> idsAcceptedArticles;
    private List<Activity> activities;
    private List<Participant> participants;
    public AcademicEvent(int uuid, String name, String initDate, String endDate, String location, String theme,
            String description, int areaDirectorId, List<Integer> idsAcceptedArticles, List<Activity> activities,
            List<Participant> participants) {
        this.uuid = uuid;
        this.name = name;
        this.initDate = initDate;
        this.endDate = endDate;
        this.location = location;
        this.theme = theme;
        this.description = description;
        this.areaDirectorId = areaDirectorId;
        this.idsAcceptedArticles = idsAcceptedArticles;
        this.activities = activities;
        this.participants = participants;
    }
    public int getUuid() {
        return uuid;
    }
    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInitDate() {
        return initDate;
    }
    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getAreaDirectorId() {
        return areaDirectorId;
    }
    public void setAreaDirectorId(int areaDirectorId) {
        this.areaDirectorId = areaDirectorId;
    }
    public List<Integer> getIdsAcceptedArticles() {
        return idsAcceptedArticles;
    }
    public void setIdsAcceptedArticles(List<Integer> idsAcceptedArticles) {
        this.idsAcceptedArticles = idsAcceptedArticles;
    }
    public List<Activity> getActivities() {
        return activities;
    }
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
    public List<Participant> getParticipants() {
        return participants;
    }
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
  
}