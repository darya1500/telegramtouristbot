package by.resliv.daryatarasevich.telegramtouristbot.model;

import java.util.Objects;

public class City {
    private int id;
    private String name;
    private String description;

    public City(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                name.equals(city.name) &&
                description.equals(city.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
