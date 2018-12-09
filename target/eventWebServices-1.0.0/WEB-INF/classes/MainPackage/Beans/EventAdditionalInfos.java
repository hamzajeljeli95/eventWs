package MainPackage.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@IdClass(EventAdditionalInfosPK.class)
public class EventAdditionalInfos {
    private int id;
    private int eventId;
    private int infoId;
    private String infoContent;
    private Event eventByEventId;
    private EventInfo eventInfoByInfoId;

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
    @Column(name = "infoId", nullable = false)
    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    @Basic
    @Column(name = "InfoContent", nullable = false, length = 2147483647)
    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventAdditionalInfos that = (EventAdditionalInfos) o;

        if (id != that.id) return false;
        if (eventId != that.eventId) return false;
        if (infoId != that.infoId) return false;
        if (infoContent != null ? !infoContent.equals(that.infoContent) : that.infoContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + eventId;
        result = 31 * result + infoId;
        result = 31 * result + (infoContent != null ? infoContent.hashCode() : 0);
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
    @JoinColumn(name = "infoId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public EventInfo getEventInfoByInfoId() {
        return eventInfoByInfoId;
    }

    public void setEventInfoByInfoId(EventInfo eventInfoByInfoId) {
        this.eventInfoByInfoId = eventInfoByInfoId;
    }
}
