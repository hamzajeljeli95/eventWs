package MainPackage.DAO;

import java.math.BigDecimal;
import java.util.List;

public interface GenericDao<E, PK extends java.io.Serializable> {
    public PK save(E newInstance);

    public boolean update(E transientObject);

    public void saveOrUpdate(E transientObject);

    public void delete(E persistentObject);

    public E findById(PK id);

    public List<E> findAll();

    public List<E> findAllBy1Properties(String propertyName1, Object value1);

    public List<E> findAllBy2Properties(String propertyName1, Object value1, String propertyName2, Object value2);

    public List<E> findAllBy3Properties(String propertyName1, Object value1, String propertyName2, Object value2, String propertyName3, Object value3);

    public E findbyCreteriaSorted(String propertyName1, Object value1, String propertyName2, Object value2, String propertyName3, String propertyName4);

    public List<E> findAllBy4Properties(String propertyName1, Object value1, String propertyName2, Object value2, String propertyName3, Object value3, String propertyName4, Object value4);

    public BigDecimal executeFunction4param(String function, String param1, String param2, String param3, String param4);
}
