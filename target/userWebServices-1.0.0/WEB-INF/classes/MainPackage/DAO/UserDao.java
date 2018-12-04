package MainPackage.DAO;

import MainPackage.Beans.AppUser;
import org.springframework.stereotype.Repository;

public interface UserDao extends GenericDao<AppUser,String> {
    public boolean login(String username,String pwdHash);
    public boolean signup(AppUser newUser);
    public AppUser getUserInfos(String username);
}
