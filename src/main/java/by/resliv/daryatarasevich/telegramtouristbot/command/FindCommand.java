package by.resliv.daryatarasevich.telegramtouristbot.command;

import by.resliv.daryatarasevich.telegramtouristbot.exception.NoSuchCityException;
import by.resliv.daryatarasevich.telegramtouristbot.model.City;
import by.resliv.daryatarasevich.telegramtouristbot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * Class to describe command for finding city specified by user in storage.
 */
@Component
@ComponentScan({"by.resliv.daryatarasevich.telegramtouristbot.service"})
public class FindCommand {
    private static CityService cityService;

    @Autowired
    public FindCommand(CityService cityService) {
        FindCommand.cityService = cityService;
    }

    /**
     * To execute command finding specific city by cityservice in storage.
     *
     * @param message
     * @return BasicCommand
     * @throws NoSuchCityException
     */
    public static BasicCommand execute(Message message) throws NoSuchCityException {
        City city = cityService.getCityByName(message.getText());
        return city::getDescription;
    }
}

