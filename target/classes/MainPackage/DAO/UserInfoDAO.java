package MainPackage.DAO;

import MainPackage.Beans.UserInfo;

import java.util.List;

public interface UserInfoDAO extends GenericDao<UserInfo,Integer> {
    public List<UserInfo> getAll();
}
