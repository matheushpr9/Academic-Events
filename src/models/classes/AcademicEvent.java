package models.classes;

import java.util.List;

public class AcademicEvent {
    private int academicEventId;
    private String name;
    private String initDate;
    private String endDate;
    private String location;
    private String theme;
    private String description;
    private Integer areaDirectorId;
    private List<Integer> idsAcceptedArticles;
    private List<Integer> activitiesId;
    private List<Integer> participantsId;
    public AcademicEvent(int academicEventId, String name, String initDate, String endDate, String location, String theme,
            String description, int areaDirectorId, List<Integer> idsAcceptedArticles, List<Integer> activitiesId,
            List<Integer> participantsId) {
        this.academicEventId = academicEventId;
        this.name = name;
        this.initDate = initDate;
        this.endDate = endDate;
        this.location = location;
        this.theme = theme;
        this.description = description;
        this.areaDirectorId = areaDirectorId;
        this.idsAcceptedArticles = idsAcceptedArticles;
        this.activitiesId = activitiesId;
        this.participantsId = participantsId;
    }
    public int getAcademicEventId() {
        return academicEventId;
    }
    public void setAcademicEventId(int academicEventId) {
        this.academicEventId = academicEventId;
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
    public List<Integer> getActivitiesId() {
        return activitiesId;
    }
    public void setActivitiesId(List<Integer> activitiesId) {
        this.activitiesId = activitiesId;
    }
    public List<Integer> getParticipantsId() {
        return participantsId;
    }
    public void setParticipantsId(List<Integer> participantsId) {
        this.participantsId = participantsId;
    }
  
}