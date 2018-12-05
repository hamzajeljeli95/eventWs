package MainPackage.Service;


import MainPackage.Beans.Event;
import MainPackage.DAO.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventDAO dao;

    public Event newEvent(String organizerId)
    {
        return dao.newEvent(organizerId);
    }

    public Event getEvent(int id)
    {
        return dao.getEvent(id);
    }

    public List<Event> getEventsByUser(String organizerId)
    {
        return dao.getEventsByUser(organizerId);
    }
}
