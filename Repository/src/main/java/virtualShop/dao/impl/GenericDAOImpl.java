package virtualShop.dao.impl;

import virtualShop.dao.GenericDAO;
import virtualShop.entity.DomainEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by laura.petrosanu on 8/6/2015.
 *         <p>
 *         Concrete implementation of the GenericDAO interface
 *         </p>
 */
public class GenericDAOImpl<T extends DomainEntity> implements GenericDAO<T> {

    private Class<T> type;
    @PersistenceContext(unitName = "repository")
    private EntityManager entityManager;

    public GenericDAOImpl(){}

    public GenericDAOImpl(Class<T> type){
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    public T getObjectById(long id) {
        return getEntityManager().find(type,id);
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getAllObjects() {
        return getEntityManager().createQuery(
                "select o from " + type.getName() + " o ").getResultList();
    }
    /**
     * {@inheritDoc}
     */
    public void save(T object) {
        getEntityManager().persist(object);
    }

        /**
     * {@inheritDoc}
     */

    public void delete(long id) {
        getEntityManager().remove(id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
