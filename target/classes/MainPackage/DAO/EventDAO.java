package MainPackage.DAO;

import MainPackage.Beans.Event;

import java.util.List;

public interface EventDAO extends GenericDao<Event,Integer> {
    public Event newEvent(String organizerId);
    public Event getEvent(int id);
    public List<Event> getEventsByUser(String organizerId);
}
