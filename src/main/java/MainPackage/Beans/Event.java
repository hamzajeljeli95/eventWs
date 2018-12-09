package MainPackage.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Event {
    private int id;
    private String organizerId;
    private AppUser appUserByOrganizerId;
    private Collection<EventAdditionalInfos> eventAdditionalInfosById;
    private Collection<EventComments> eventCommentsById;
    private Collection<EventParticipants> eventParticipantsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "organizerId", nullable = false, length = 64)
    public String getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (organizerId != null ? !organizerId.equals(event.organizerId) : event.organizerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (organizerId != null ? organizerId.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "organizerId", referencedColumnName = "username", nullable = false, insertable = false, updatable = false)
    public AppUser getAppUserByOrganizerId() {
        return appUserByOrganizerId;
    }

    public void setAppUserByOrganizerId(AppUser appUserByOrganizerId) {
        this.appUserByOrganizerId = appUserByOrganizerId;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "eventByEventId")
    public Collection<EventAdditionalInfos> getEventAdditionalInfosById() {
        return eventAdditionalInfosById;
    }

    public void setEventAdditionalInfosById(Collection<EventAdditionalInfos> eventAdditionalInfosById) {
        this.eventAdditionalInfosById = eventAdditionalInfosById;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "eventByIdEvent")
    public Collection<EventComments> getEventCommentsById() {
        return eventCommentsById;
    }

    public void setEventCommentsById(Collection<EventComments> eventCommentsById) {
        this.eventCommentsById = eventCommentsById;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "eventByEventId")
    public Collection<EventParticipants> getEventParticipantsById() {
        return eventParticipantsById;
    }

    public void setEventParticipantsById(Collection<EventParticipants> eventParticipantsById) {
        this.eventParticipantsById = eventParticipantsById;
    }
}
