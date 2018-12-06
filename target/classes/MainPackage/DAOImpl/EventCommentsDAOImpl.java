package MainPackage.DAOImpl;

import MainPackage.Beans.EventComments;
import MainPackage.DAO.EventCommentsDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventCommentsDAOImpl extends GenericDaoImpl<EventComments,Integer> implements EventCommentsDAO {
    public List<EventComments> getCommentsByEventId(int eventId) {
        return findAllBy1Properties("idEvent",eventId);
    }

    public EventComments getUserCommentByEventId(int eventId, String idUser) {
        return findAllBy2Properties("idEvent",eventId,"idUser",idUser).get(0);
    }

    public boolean newComment(int eventId, String idUser, String commentContent) {
        EventComments comments = new EventComments();
        comments.setCommentContent(commentContent);
        comments.setIdEvent(eventId);
        comments.setIdUser(idUser);
        return this.save(comments)!=null;
    }
}
