package classes;

import java.util.List;

public class Activity {
    private int uuid;
    private String title;
    private String activityType; // palestra, painel, workshop, etc.
    private String startTime;
    private String endTime;
    private int roomId;
    private List<Participant> registeredParticipants;
    //private List<String> listaEspera;

    public Activity(int uuid, String title, String activityType, String startTime, String endTime, int roomId,
            List<Participant> registeredParticipants) {
        this.uuid = uuid;
        this.title = title;
        this.activityType = activityType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomId = roomId;
        this.registeredParticipants = registeredParticipants;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public List<Participant> getRegisteredParticipants() {
        return registeredParticipants;
    }

    public void setRegisteredParticipants(List<Participant> registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }

}