package classes.certificates;

import java.sql.Date;

public class ParticipationCertificate extends BaseCertificate{
    private String participantName;

    public ParticipationCertificate(String eventName, Date date, String text, String participantName) {
        super(eventName, date, text);
        this.participantName = participantName;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }
    
}
