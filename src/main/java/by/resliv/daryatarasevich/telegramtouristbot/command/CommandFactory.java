package by.resliv.daryatarasevich.telegramtouristbot.command;

public class CommandFactory {

    public static BasicCommand defineCommand(String message) {
        BasicCommand command=new HelpCommand();
        try {
            CommandsConstants[] constants = CommandsConstants.values();
            for (CommandsConstants c:constants ){
                if (c.text.equalsIgnoreCase(message)){
                    command=c.getCurrentCommand();
                }
            }
        }catch (IllegalArgumentException e){
          //todo log
        }
        return command;
    }
}
