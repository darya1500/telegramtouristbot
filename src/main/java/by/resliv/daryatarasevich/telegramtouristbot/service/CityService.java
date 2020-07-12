package by.resliv.daryatarasevich.telegramtouristbot.service;

import by.resliv.daryatarasevich.telegramtouristbot.exception.NoSuchCityException;
import by.resliv.daryatarasevich.telegramtouristbot.model.City;
import by.resliv.daryatarasevich.telegramtouristbot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service class.
 *
 * @author darya tarasevich
 */
@ComponentScan("by.resliv.daryatarasevich.telegramtouristbot.repository")
@Transactional(readOnly = true)
@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * To get all cities from cityRepository.
     *
     * @return list of cities
     */
    @Transactional
    public List<City> getAllCities() {
        return cityRepository.getAll();
    }
    /**
     * To get city by specific id from cityRepository.
     *
     * @return city
     */
    @Transactional
    public City getCityById(int id) {
        return cityRepository.get(id);
    }

    /**
     * To delete city from cityRepository.
     *
     */
    @Transactional
    public void deleteCity(int id) {
        City city = cityRepository.get(id);
        cityRepository.delete(city);
    }

    /**
     * To save city to cityRepository.
     *
     * @param city
     */
    @Transactional
    public void saveCity(City city) {
        cityRepository.add(city.getName(),city.getDescription());
    }

    /**
     *  To update city in cityRepository
     * @param city
     * @return city
     */
    @Transactional
    public City updateCity(City city) {
        String name=city.getName();
        City receivedCity = cityRepository.get(name);
        cityRepository.update(city.getName(),city.getDescription(),receivedCity.getId());
        return receivedCity;
    }
    /**
     * To get city by specific name from cityRepository.
     *
     * @return city
     * @throws NoSuchCityException
     */
    @Transactional
    public City getCityByName(String cityName) throws NoSuchCityException {
        try {
            return cityRepository.get(cityName);
        }catch (NullPointerException e){
            throw new NoSuchCityException();
        }
    }
}
