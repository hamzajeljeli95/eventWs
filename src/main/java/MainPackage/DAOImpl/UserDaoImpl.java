package MainPackage.DAOImpl;

import MainPackage.Beans.AppUser;
import MainPackage.DAO.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<AppUser,String> implements UserDao {

    public boolean login(String username, String pwdHash) {
        return (this.findAllBy4Properties("username",username,"passwordHash",pwdHash,"profile",1,"isConfirmed",1).size()==1);
    }

    public boolean signup(AppUser newUser) {
        return this.save(newUser)!=null;
    }

    public AppUser getUserInfos(String username) {
        return this.findAllBy1Properties("username",username).get(0);
    }
}
