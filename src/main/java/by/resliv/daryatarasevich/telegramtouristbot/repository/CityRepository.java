package by.resliv.daryatarasevich.telegramtouristbot.repository;

import by.resliv.daryatarasevich.telegramtouristbot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface.
 *
 * @author darya tarasevich
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    /**
     * To get all cities from database.
     *
     * @return List of cities
     */
    @Query("SELECT u FROM City u ORDER BY u.name")
    List<City> getAll();

    /**
     * To add city to database.
     *
     * @param name
     * @param description
     */
    @Query("update City u set u.name=?1,u.description=?2")
    @Modifying
    void add(String name,String description);

    /**
     * To delete city from database.
     *
     * @param id
     */
    @Query("delete from City u where u.id=?1")
    void delete(int id);

    /**
     * To get city with specific id from database.
     *
     * @param id
     * @return city
     */
    @Query("SELECT u FROM City u WHERE u.id = ?1")
    City get(int id);

    /**
     * To get city with specific name from database.
     *
     * @param name
     * @return city
     */
    @Query("SELECT u FROM City u WHERE u.name = ?1")
    City get(String name);

    /**
     * To update city in database.
     *
     * @param name
     * @param description
     * @param id
     */
    @Query("update City u set u.name = ?1, u.description=?2 where u.id=?3")
    @Modifying
    void update(String name,String description,int id);
}

