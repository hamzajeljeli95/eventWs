package MainPackage.Beans;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class EventInfo {
    private int id;
    private String infoType;
    private Collection<EventAdditionalInfos> eventAdditionalInfosById;

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
    @Column(name = "infoType", nullable = false, length = 64)
    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventInfo eventInfo = (EventInfo) o;

        if (id != eventInfo.id) return false;
        if (infoType != null ? !infoType.equals(eventInfo.infoType) : eventInfo.infoType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (infoType != null ? infoType.hashCode() : 0);
        return result;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "eventInfoByInfoId")
    public Collection<EventAdditionalInfos> getEventAdditionalInfosById() {
        return eventAdditionalInfosById;
    }

    public void setEventAdditionalInfosById(Collection<EventAdditionalInfos> eventAdditionalInfosById) {
        this.eventAdditionalInfosById = eventAdditionalInfosById;
    }
}
