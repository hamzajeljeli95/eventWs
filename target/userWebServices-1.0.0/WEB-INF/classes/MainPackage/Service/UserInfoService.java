package MainPackage.Service;

import MainPackage.Beans.UserInfo;
import MainPackage.DAO.UserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoDAO userInfoDAO;

    public List<UserInfo> getAll()
    {
        return userInfoDAO.getAll();
    }
}
