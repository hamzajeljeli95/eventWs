package MainPackage.Service;

import MainPackage.Beans.EventAdditionalInfos;
import MainPackage.DAO.EventAdditionalInfosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAdditionalInfosService {

    @Autowired
    EventAdditionalInfosDAO dao;

    public List<EventAdditionalInfos> getEventAdditionalInfos(int id)
    {
        return dao.getEventAdditionalInfos(id);
    }
    public EventAdditionalInfos getSpecificEventAdditionalInfo(int id, int itemId)
    {
        return dao.getSpecificEventAdditionalInfo(id,itemId);
    }
    public boolean addEventAdditionalInfo(EventAdditionalInfos infos)
    {
        return dao.addEventAdditionalInfo(infos);
    }
}
