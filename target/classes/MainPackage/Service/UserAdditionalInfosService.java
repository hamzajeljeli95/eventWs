package MainPackage.Service;

import MainPackage.Beans.UserAdditionalInfos;
import MainPackage.DAO.UserAdditionalInfosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdditionalInfosService {

    @Autowired
    UserAdditionalInfosDAO additionalInfosDAO;

    public UserAdditionalInfos getAdditionalInfo(int infoId, String userId)
    {
        return additionalInfosDAO.getAdditionalInfo(infoId,userId);
    }
    public List<UserAdditionalInfos> getUserAdditionalInfos(String userId)
    {
        return additionalInfosDAO.getUserAdditionalInfos(userId);
    }
    public boolean setUserAdditionalInfo(int infoId,String userId,String content)
    {
        return additionalInfosDAO.setUserAdditionalInfo(infoId,userId,content);
    }
}
