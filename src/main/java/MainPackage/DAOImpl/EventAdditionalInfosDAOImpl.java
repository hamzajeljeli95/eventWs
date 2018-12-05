package MainPackage.DAOImpl;

import MainPackage.Beans.EventAdditionalInfos;
import MainPackage.DAO.EventAdditionalInfosDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventAdditionalInfosDAOImpl extends GenericDaoImpl<EventAdditionalInfos,Integer> implements EventAdditionalInfosDAO {
    public List<EventAdditionalInfos> getEventAdditionalInfos(int id) {
        return findAllBy1Properties("eventId",id);
    }

    public EventAdditionalInfos getSpecificEventAdditionalInfo(int infoId, int eventId) {
        return findAllBy2Properties("infoId",infoId,"eventId",eventId).get(0);
    }

    public boolean addEventAdditionalInfo(EventAdditionalInfos infos) {
        return this.save(infos)!=null;
    }
}
