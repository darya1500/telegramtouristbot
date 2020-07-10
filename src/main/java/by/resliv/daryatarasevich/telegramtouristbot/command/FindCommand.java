package by.resliv.daryatarasevich.telegramtouristbot.command;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class FindCommand implements BasicCommand {
//    public HelloCommand(String commandIdentifier, String description) {
//        super(commandIdentifier, description);
//    }

    @Override
    public String execute() {
        return "Hello command";
    }
}
