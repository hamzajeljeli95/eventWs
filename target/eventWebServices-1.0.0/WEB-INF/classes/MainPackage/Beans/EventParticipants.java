package MainPackage.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@IdClass(EventParticipantsPK.class)
public class EventParticipants {
    private int id;
    private int eventId;
    private String participantId;
    private Event eventByEventId;
    private AppUser appUserByParticipantId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "eventId", nullable = false)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Id
    @Column(name = "participantId", nullable = false, length = 64)
    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventParticipants that = (EventParticipants) o;

        if (id != that.id) return false;
        if (eventId != that.eventId) return false;
        if (participantId != null ? !participantId.equals(that.participantId) : that.participantId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + eventId;
        result = 31 * result + (participantId != null ? participantId.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eventId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Event getEventByEventId() {
        return eventByEventId;
    }

    public void setEventByEventId(Event eventByEventId) {
        this.eventByEventId = eventByEventId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "participantId", referencedColumnName = "username", nullable = false, insertable = false, updatable = false)
    public AppUser getAppUserByParticipantId() {
        return appUserByParticipantId;
    }

    public void setAppUserByParticipantId(AppUser appUserByParticipantId) {
        this.appUserByParticipantId = appUserByParticipantId;
    }
}
