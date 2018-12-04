package MainPackage.DAOImpl;

import MainPackage.Beans.UserInfo;
import MainPackage.DAO.UserInfoDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoDAOImpl extends GenericDaoImpl<UserInfo,Integer> implements UserInfoDAO {
    public List<UserInfo> getAll() {
        return this.findAll();
    }
}
