package MainPackage.Beans;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserAdditionalInfosPK implements Serializable {
    private int id;
    private String userId;
    private int infoId;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "userId", nullable = false, length = 64)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "infoId", nullable = false)
    @Id
    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAdditionalInfosPK that = (UserAdditionalInfosPK) o;

        if (id != that.id) return false;
        if (infoId != that.infoId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + infoId;
        return result;
    }
}
