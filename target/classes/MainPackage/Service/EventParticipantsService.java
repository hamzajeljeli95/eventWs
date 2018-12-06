package MainPackage.Service;

import MainPackage.Beans.EventParticipants;
import MainPackage.DAO.EventParticipantsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventParticipantsService {

    @Autowired
    EventParticipantsDAO dao;

    public List<EventParticipants> getParticipantsByEvent(int idEvent) {
        return dao.getParticipantsByEvent(idEvent);
    }

    public List<EventParticipants> getEventsByParticipant(String idParticipant) {
        return dao.getEventsByParticipant(idParticipant);
    }

    public boolean participateToEvent(int idEvent, String idParticipant) {
        return dao.participateToEvent(idEvent,idParticipant);
    }
}
