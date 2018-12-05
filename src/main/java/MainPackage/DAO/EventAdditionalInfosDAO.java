package MainPackage.DAO;

import MainPackage.Beans.EventAdditionalInfos;

import java.util.List;

public interface EventAdditionalInfosDAO extends GenericDao<EventAdditionalInfos,Integer> {
    public List<EventAdditionalInfos> getEventAdditionalInfos(int id);
    public EventAdditionalInfos getSpecificEventAdditionalInfo(int id, int itemId);
    public boolean addEventAdditionalInfo(EventAdditionalInfos infos);
}
