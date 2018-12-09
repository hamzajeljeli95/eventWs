package MainPackage.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class EventComments {
    private int id;
    private int idEvent;
    private String idUser;
    private String commentContent;
    private Date dateTimeComment;
    private Event eventByIdEvent;
    private AppUser appUserByIdUser;

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
    @Column(name = "idEvent", nullable = false)
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    @Basic
    @Column(name = "idUser", nullable = false, length = 64)
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "commentContent", nullable = false, length = 2147483647)
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "dateTimeComment", nullable = false)
    public Date getDateTimeComment() {
        return dateTimeComment;
    }

    public void setDateTimeComment(Date dateTimeComment) {
        this.dateTimeComment = dateTimeComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventComments that = (EventComments) o;

        if (id != that.id) return false;
        if (commentContent != null ? !commentContent.equals(that.commentContent) : that.commentContent != null)
            return false;
        if (dateTimeComment != null ? !dateTimeComment.equals(that.dateTimeComment) : that.dateTimeComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + (dateTimeComment != null ? dateTimeComment.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idEvent", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Event getEventByIdEvent() {
        return eventByIdEvent;
    }

    public void setEventByIdEvent(Event eventByIdEvent) {
        this.eventByIdEvent = eventByIdEvent;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "username", nullable = false, insertable = false, updatable = false)
    public AppUser getAppUserByIdUser() {
        return appUserByIdUser;
    }

    public void setAppUserByIdUser(AppUser appUserByIdUser) {
        this.appUserByIdUser = appUserByIdUser;
    }
}
