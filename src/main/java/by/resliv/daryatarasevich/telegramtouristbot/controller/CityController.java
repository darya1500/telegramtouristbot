package by.resliv.daryatarasevich.telegramtouristbot.controller;

import by.resliv.daryatarasevich.telegramtouristbot.model.City;
import by.resliv.daryatarasevich.telegramtouristbot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller class.
 *
 * @author darya tarasevich
 */
@RestController
@RequestMapping("/cities")
@ComponentScan({"by.resliv.daryatarasevich.telegramtouristbot.service"})
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     *  To get all cities from database via service.
     *
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> getAllCities() {
        List<City> foundCities = cityService.getAllCities();
        return new ResponseEntity<>(foundCities, HttpStatus.OK);
    }

    /**
     * To get city by id from database via service.
     *
     * @param id
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCityById(@PathVariable int id) {
        City foundCity = cityService.getCityById(id);
        return new ResponseEntity<>(foundCity, HttpStatus.OK);
    }

    /**
     * To save city in database via service.
     *
     * @param city
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveCity(@Valid @RequestBody City city) {
        cityService.saveCity(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    /**
     * To update city in database via service.
     *
     * @param city
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        City updatedCity = cityService.updateCity(city);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    /**
     * To delete city from database via service.
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

