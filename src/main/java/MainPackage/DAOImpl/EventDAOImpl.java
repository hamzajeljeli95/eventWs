package MainPackage.DAOImpl;

import MainPackage.Beans.Event;
import MainPackage.DAO.EventDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class EventDAOImpl extends GenericDaoImpl<Event,Integer> implements EventDAO {

    public Event newEvent(String organizerId) {
        Session session=sessionFactory.openSession();
        Event event = new Event();
        event.setOrganizerId(organizerId);
        int result = -1;
        try {
            Serializable ser = session.save(event);
            if (ser != null) {
                result = (Integer) ser;
            }
            event.setId(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return event;
    }

    public Event getEvent(int id) {
        return findAllBy1Properties("id",id).get(0);
    }

    public List<Event> getEventsByUser(String organizerId) {
        return findAllBy1Properties("organizerId",organizerId);
    }
}
