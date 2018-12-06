package MainPackage.Service;

import MainPackage.Beans.EventInfo;
import MainPackage.DAO.EventInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventInfoService {

    @Autowired
    EventInfoDAO dao;

    public List<EventInfo> getAll() {
        return dao.getAll();
    }
}
