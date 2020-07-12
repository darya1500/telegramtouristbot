package by.resliv.daryatarasevich.telegramtouristbot.command;

import by.resliv.daryatarasevich.telegramtouristbot.bot.TouristBot;
import by.resliv.daryatarasevich.telegramtouristbot.exception.NoSuchCityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static by.resliv.daryatarasevich.telegramtouristbot.command.CommandsConstants.*;

/**
 * Class to choose command from commands constants based on incoming update.
 *
 * @author darya tarasevich
 */
@Component
public class CommandFactory {
    private static final Logger log = LogManager.getLogger(CommandFactory.class);

    /**
     * To define command from commands constants based on incoming update.
     *
     * @param update
     */
    public static BasicCommand defineCommand(Update update) throws NoSuchCityException {
        Message message = update.getMessage();
        String textMessage;
        try {
            textMessage = message.getText();
        } catch (NullPointerException e) {
            log.debug(e);
            textMessage = update.getCallbackQuery().getData();
        }
        if (START.equals(textMessage)) {
            return GeneralCommand.startCommand(message);
        } else if (HELP.equals(textMessage)) {
            return GeneralCommand.helpCommand(update);
        }
        return FindCommand.execute(message);
    }
}
