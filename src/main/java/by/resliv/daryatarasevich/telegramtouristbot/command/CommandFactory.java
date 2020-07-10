package by.resliv.daryatarasevich.telegramtouristbot.command;

import org.telegram.telegrambots.meta.api.objects.Message;

public class CommandFactory {

    public static BasicCommand defineCommand(Message message) {
        BasicCommand command=new HelpCommand();
        try {
            CommandsConstants[] constants = CommandsConstants.values();
            for (CommandsConstants c:constants ){
                if (c.text.equalsIgnoreCase(message.getText())){
                    command=c.getCurrentCommand();
                }
            }
        }catch (IllegalArgumentException e){
          //todo log
        }
        return command;
    }
}
