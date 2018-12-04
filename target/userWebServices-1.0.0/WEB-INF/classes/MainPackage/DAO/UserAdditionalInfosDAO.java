package MainPackage.DAO;

import MainPackage.Beans.UserAdditionalInfos;

import java.util.List;

public interface UserAdditionalInfosDAO extends GenericDao<UserAdditionalInfos,Integer> {
    public UserAdditionalInfos getAdditionalInfo(int infoId,String userId);
    public List<UserAdditionalInfos> getUserAdditionalInfos(String userId);
    public boolean setUserAdditionalInfo(int infoId,String userId,String content);
}
