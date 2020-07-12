package by.resliv.daryatarasevich.telegramtouristbot.command;

import by.resliv.daryatarasevich.telegramtouristbot.exception.NoSuchCityException;

/**
 * Basic command interface.
 *
 * @author darya tarasevich
 */
public interface BasicCommand  {
    String perform() throws NoSuchCityException;
}