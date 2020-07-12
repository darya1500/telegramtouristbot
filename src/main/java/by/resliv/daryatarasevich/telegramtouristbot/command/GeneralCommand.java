package by.resliv.daryatarasevich.telegramtouristbot.command;

import by.resliv.daryatarasevich.telegramtouristbot.util.MessageConstants;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Class describing general commands.
 *
 * @author darya tarasevich
 */
@Component
public class GeneralCommand {
    /**
     * To execute start command.
     *
     * @param message
     * @return BasicCommand
     */
    public static BasicCommand startCommand(Message message) {
        return () -> MessageConstants.START_RESPONSE;
    }

    /**
     * To execute help command.
     *
     * @param update
     * @return BasicCommand
     */
    public static BasicCommand helpCommand(Update update) {
        return () -> MessageConstants.HELP_RESPONSE;
    }

    /**
     * To execute default command.
     *
     * @param message
     * @return BasicCommand
     */
    public static BasicCommand defaultCommand(String message) {
        return () -> MessageConstants.DEFAULT_RESPONSE;
    }

}