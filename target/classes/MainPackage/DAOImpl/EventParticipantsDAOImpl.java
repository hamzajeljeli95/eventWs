package MainPackage.DAOImpl;

import MainPackage.Beans.EventParticipants;
import MainPackage.DAO.EventParticipantsDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventParticipantsDAOImpl extends GenericDaoImpl<EventParticipants,Integer> implements EventParticipantsDAO
{

    public List<EventParticipants> getParticipantsByEvent(int idEvent) {
        return findAllBy1Properties("eventId",idEvent);
    }

    public List<EventParticipants> getEventsByParticipant(String idParticipant) {
        return findAllBy1Properties("participantId",idParticipant);
    }

    public boolean participateToEvent(int idEvent, String idParticipant) {
        EventParticipants participant = new EventParticipants();
        participant.setEventId(idEvent);
        participant.setParticipantId(idParticipant);
        return this.save(participant)!=null;
    }
}
