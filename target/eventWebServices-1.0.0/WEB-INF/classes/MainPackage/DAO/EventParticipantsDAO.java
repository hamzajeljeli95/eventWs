package MainPackage.DAO;

import MainPackage.Beans.EventParticipants;

import java.util.List;

public interface EventParticipantsDAO extends GenericDao<EventParticipants,Integer> {
    public List<EventParticipants> getParticipantsByEvent(int idEvent);
    public List<EventParticipants> getEventsByParticipant(String idParticipant);
    public boolean participateToEvent(int idEvent,String idParticipant);
}
