package MainPackage.DAOImpl;

import MainPackage.DAO.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


@Repository("genericDao")
public abstract class GenericDaoImpl<E, PK extends java.io.Serializable> implements GenericDao<E, PK> {


    private static SessionFactory sessionFactory;  //comes in from bean

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.SessionFactory : \n" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private Class<E> entityClass;

    //constructors
    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    //getters and setters
    public Class<E> getEntityClass() {
        return entityClass;
    }

    // CRUD stuff
    @SuppressWarnings("unchecked")

    public PK save(E newInstance) {
        PK result = null;
        try {
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            result = (PK) session.save(newInstance);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.Save : \n" + ex.getMessage());
        }
        return result;
    }

    public boolean update(E transientObject) {
        try {
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.update(transientObject);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.Update : \n" + ex.getMessage());
            return false;
        }
    }

    public void saveOrUpdate(E transientObject) {
        try {
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(transientObject);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.saveOrUpdate : \n" + ex.getMessage());
        }
    }

    public void delete(E persistentObject) {
        try {
            Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.delete(persistentObject);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.delete : \n" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public E findById(PK id) {
        List<E> results = null;
        E result = null;
        try {
            Session session = this.sessionFactory.openSession();
            Criteria crit = session.createCriteria(entityClass);
            crit.add(Restrictions.eq("id", id));
            results = crit.list();
            if (!results.isEmpty()) {
                if (results.size() == 1) {
                    result = results.get(0);
                }
            }
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.findById : \n" + ex.getMessage());
        }
        return result;
    }


    //@SuppressWarnings("unchecked")
    //@Transactional(readOnly = true)
    public List<E> findAll() {
        List<E> results = null;
        try {
            Session session = this.sessionFactory.openSession();
            Criteria crit = session.createCriteria(getEntityClass());
            results = crit.list();
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.findAll : \n" + ex.getMessage());
        }
        return results;
    }

    @SuppressWarnings("unchecked")

    public List<E> findAllBy1Properties(String propertyName1, Object value1) {
        List<E> results = null;
        try {
            Session session = this.sessionFactory.openSession();
            results = session.createQuery("from " + getEntityClass().getName() + " u where u." + propertyName1 + " = :one")
                    .setParameter("one", value1)
                    .list();
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.findAllBy1Properties : \n" + ex.getMessage());
        }
        return results;
    }

    public List<E> findAllBy2Properties(String propertyName1, Object value1, String propertyName2, Object value2) {
        List<E> results = null;
        try {
            Session session = this.sessionFactory.openSession();
            results = session.createQuery("from " + getEntityClass().getName() + " u where u." + propertyName1 + " = :one and u." + propertyName2 + " = :two ")
                    .setParameter("one", value1)
                    .setParameter("two", value2)
                    .list();
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.findAllBy2Properties : \n" + ex.getMessage());
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    public List<E> findAllBy3Properties(String propertyName1, Object value1, String propertyName2, Object value2, String propertyName3, Object value3) {
        List<E> results = null;
        try {
            Session session = this.sessionFactory.openSession();
            results = session.createQuery("from " + getEntityClass().getName() + " u where u." + propertyName1 + " = :one and u." + propertyName2 + " = :two and u." + propertyName3 + " = :three")
                    .setParameter("one", value1)
                    .setParameter("two", value2)
                    .setParameter("three", value3)
                    .list();

            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.findAllBy3Properties : \n" + ex.getMessage());
        }
        return results;

    }

    @SuppressWarnings("unchecked")
    public List<E> findAllBy4Properties(String propertyName1, Object value1, String propertyName2, Object value2, String propertyName3, Object value3, String propertyName4, Object value4) {
        List<E> results = null;
        try {
            Session session = this.sessionFactory.openSession();
            results = session.createQuery("from " + getEntityClass().getName() + " u where u." + propertyName1 + " = :one and u." + propertyName2 + " = :two and u." + propertyName3 + " = :three and u." + propertyName4 + " = :four")
                    .setParameter("one", value1)
                    .setParameter("two", value2)
                    .setParameter("three", value3)
                    .setParameter("four", value4)
                    .list();
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.findAllBy4Properties : \n" + ex.getMessage());
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    public E findbyCreteriaSorted(String propertyName1, Object value1, String propertyName2, Object value2, String propertyName3, String propertyName4) {
        E result = null;
        try {
            Session session = this.sessionFactory.openSession();
            Query query = session.createQuery("from " + getEntityClass().getName() + " u where u." + propertyName1 + " = ? and u." + propertyName2 + " = ? order by u." + propertyName3 + " desc,u." + propertyName4 + " desc");
            query.setParameter(0, value1);
            query.setParameter(1, value2);
            result = (E) query.uniqueResult();
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.findbyCreteriaSorted : \n" + ex.getMessage());
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    public BigDecimal executeFunction4param(String function, String param1, String param2, String param3, String param4) {
        BigDecimal obj = null;
        try {
            Session session = this.sessionFactory.openSession();
            Query q = session.createSQLQuery("select " + function + "(:mat,:cle,:trim,:annee)from dual");
            q.setString("mat", param1);
            q.setString("cle", param2);
            q.setString("trim", param3);
            q.setString("annee", param4);
            List l = q.list();

            for (Iterator it = l.iterator(); it.hasNext(); ) {
                obj = (BigDecimal) it.next();
            }
            session.close();
        } catch (Exception ex) {
            System.err.println("Erreur Dans GenericDAO.executeFunction4param : \n" + ex.getMessage());
        }
        return obj;
    }

}