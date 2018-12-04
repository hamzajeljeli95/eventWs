package MainPackage.DAOImpl;

import MainPackage.Beans.UserAdditionalInfos;
import MainPackage.DAO.UserAdditionalInfosDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAdditionalInfosDAOImpl extends GenericDaoImpl<UserAdditionalInfos,Integer> implements UserAdditionalInfosDAO {
    public UserAdditionalInfos getAdditionalInfo(int infoId, String userId) {
        return this.findAllBy2Properties("infoId",infoId,"userId",userId).get(0);
    }

    public List<UserAdditionalInfos> getUserAdditionalInfos(String userId) {
        return this.findAllBy1Properties("userId",userId);
    }

    public boolean setUserAdditionalInfo(int infoId, String userId, String content) {
        UserAdditionalInfos additionalInfos = new UserAdditionalInfos();
        additionalInfos.setInfoId(infoId);
        additionalInfos.setUserId(userId);
        additionalInfos.setInfoContent(content);
        return this.save(additionalInfos)!=null;
    }

}
