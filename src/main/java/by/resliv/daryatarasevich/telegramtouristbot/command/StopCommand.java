package by.resliv.daryatarasevich.telegramtouristbot.command;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public final class StopCommand implements BasicCommand {
    @Override
    public String  execute() {
        return "Stop command";
    }
//    public StopCommand(String commandIdentifier, String description) {
//        super(commandIdentifier, description);
//    }
//
//    @Override
//    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
//
//    }

//    private final CityService service;
//
//    public StopCommand(CityService service, CityService service1) {
//        super("stop", "remove yourself from bot users' list\n");
//        this.service = service1;
//        service=service;
//    }
//
//    //@Override
//    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
//
//    }
//
//    @Override
//    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
//       // log.info(LogTemplate.COMMAND_PROCESSING.getTemplate(), user.getId(), getCommandIdentifier());
//        StringBuilder sb = new StringBuilder();
//        SendMessage message = new SendMessage();
//        message.setChatId(chat.getId().toString());
//        if (service.removeSomething(user)) {
//            //log.info("User {} has been removed from users list!", user.getId());
//            sb.append("You've been removed from bot's users list! Bye!");
//        } else {
//           // log.log(Level.getLevel(LogLevel.STRANGE.getValue()), "User {} is trying to execute '{}' without having executed 'start' before!", user.getId(), getCommandIdentifier());
//            sb.append("You were not in bot users' list. Bye!");
//        }
//        message.setText(sb.toString());
//        execute(absSender, message, user);
//    }
}
