package virtualShop.dao;

import java.util.List;

/**
 * Created by laura.petrosanu on 8/6/2015.
 *          <p>
 *         Generic interface defined for basic CRUD operations
 *         </p>
 */
public interface GenericDAO<T> {

    /**
     * method to retrieve and object from database by id
     * @param id criteria to search by
     * @return the matching object
     */
    public T getObjectById(int id);

    /**
     * method to retrieve all objects from database
     * @return the list of objects
     */
    public List<T> getAllObjects();

    /**
     * method to add a object into the database
     * @param object
     */
    public void save(T object);

    /**
     * method to delete an object from database
     * @param id criteria to delete
     */
    public void delete(int id);

}
