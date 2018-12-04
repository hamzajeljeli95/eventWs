package MainPackage.Service;

import MainPackage.Beans.AppUser;
import MainPackage.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean login(String username,String pwdHash)
    {
        return userDao.login(username,pwdHash);
    }

    public AppUser getUserInfos(String username) {
        return userDao.getUserInfos(username);
    }

    public boolean signup(AppUser newUser) {
        return userDao.signup(newUser);
    }
}
