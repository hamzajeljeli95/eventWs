package MainPackage.Beans;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.Collection;

@Entity
public class AppUser {
    private String username;
    private String passwordHash;
    private int isConfirmed;
    private int profile;
    private Collection<Event> eventsByUsername;
    private Collection<EventComments> eventCommentsByUsername;
    private Collection<EventParticipants> eventParticipantsByUsername;
    private Collection<UserAdditionalInfos> userAdditionalInfosByUsername;

    @Id
    @Column(name = "username", nullable = false, length = 64)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "passwordHash", nullable = false, length = 2147483647)
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "isConfirmed", nullable = false)
    public int getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(int isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @Basic
    @Column(name = "profile", nullable = false)
    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        if (isConfirmed != appUser.isConfirmed) return false;
        if (profile != appUser.profile) return false;
        if (username != null ? !username.equals(appUser.username) : appUser.username != null) return false;
        if (passwordHash != null ? !passwordHash.equals(appUser.passwordHash) : appUser.passwordHash != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + isConfirmed;
        result = 31 * result + profile;
        return result;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "appUserByOrganizerId")
    public Collection<Event> getEventsByUsername() {
        return eventsByUsername;
    }

    public void setEventsByUsername(Collection<Event> eventsByUsername) {
        this.eventsByUsername = eventsByUsername;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "appUserByIdUser")
    public Collection<EventComments> getEventCommentsByUsername() {
        return eventCommentsByUsername;
    }

    public void setEventCommentsByUsername(Collection<EventComments> eventCommentsByUsername) {
        this.eventCommentsByUsername = eventCommentsByUsername;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "appUserByParticipantId")
    public Collection<EventParticipants> getEventParticipantsByUsername() {
        return eventParticipantsByUsername;
    }

    public void setEventParticipantsByUsername(Collection<EventParticipants> eventParticipantsByUsername) {
        this.eventParticipantsByUsername = eventParticipantsByUsername;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "appUserByUserId")
    public Collection<UserAdditionalInfos> getUserAdditionalInfosByUsername() {
        return userAdditionalInfosByUsername;
    }

    public void setUserAdditionalInfosByUsername(Collection<UserAdditionalInfos> userAdditionalInfosByUsername) {
        this.userAdditionalInfosByUsername = userAdditionalInfosByUsername;
    }
}
