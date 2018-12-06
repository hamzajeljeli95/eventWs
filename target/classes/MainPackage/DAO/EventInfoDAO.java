package MainPackage.DAO;

import MainPackage.Beans.EventInfo;

import java.util.List;

public interface EventInfoDAO extends GenericDao<EventInfo,Integer> {
    public List<EventInfo> getAll();
}
