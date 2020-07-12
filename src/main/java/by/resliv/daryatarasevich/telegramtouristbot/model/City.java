package by.resliv.daryatarasevich.telegramtouristbot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Entity class.
 *
 * @author darya tarasevich
 */
@Entity
@Table(name = "cities", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "cities_unique_name_idx")})
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    public City() {
    }

    public City(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public City(@NotNull String name, @NotNull String description) {
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
