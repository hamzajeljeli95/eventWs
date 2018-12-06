package MainPackage.DAOImpl;

import MainPackage.Beans.EventInfo;
import MainPackage.DAO.EventInfoDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventInfoDAOImpl extends GenericDaoImpl<EventInfo,Integer> implements EventInfoDAO {
    public List<EventInfo> getAll() {
        return findAll();
    }
}
