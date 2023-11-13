package classes;

import java.sql.Date;
import java.util.List;

public class Schedule {
    private Date day;
    private List<Activity> activities;

    public Schedule(Date day, List<Activity> activities) {
        this.day = day;
        this.activities = activities;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void setActivitiesByDate(){
        
    }
    
}
