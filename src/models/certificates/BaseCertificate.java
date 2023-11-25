package models.certificates;

import java.sql.Date;

public class BaseCertificate {
    private String eventName;
    private Date date;
    private String text;
    
    public BaseCertificate(String eventName, Date date, String text) {
        this.eventName = eventName;
        this.date = date;
        this.text = text;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
