package MainPackage.Service;


import MainPackage.Beans.EventComments;
import MainPackage.DAO.EventCommentsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventCommentsService {

    @Autowired
    EventCommentsDAO dao;

    public List<EventComments> getCommentsByEventId(int eventId)
    {
        return dao.getCommentsByEventId(eventId);
    }

    public EventComments getUserCommentByEventId(int eventId,String idUser)
    {
        return dao.getUserCommentByEventId(eventId, idUser);
    }
    public boolean newComment(int eventId, String idUser,String commentContent)
    {
        return dao.newComment(eventId,idUser,commentContent);
    }

}
