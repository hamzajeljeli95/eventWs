package MainPackage.DAO;

import MainPackage.Beans.EventComments;

import java.util.List;

public interface EventCommentsDAO extends GenericDao<EventComments,Integer> {
    public List<EventComments> getCommentsByEventId(int eventId);
    public EventComments getUserCommentByEventId(int eventId,String idUser);
    public boolean newComment(int eventId, String idUser,String commentContent);
}
