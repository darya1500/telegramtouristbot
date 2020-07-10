package by.resliv.daryatarasevich.telegramtouristbot.command;


public enum CommandsConstants {
    START("/start") {
        {
            this.command = new StartCommand();
        }
    },
    HELP("/help") {{
        this.command = new HelpCommand();
    }
    },
    FIND("/find") {
        {
            this.command = new FindCommand();
        }
    },
    STOP("/stop") {
        {
            this.command = new StopCommand();
        }
    };

    String text;
    BasicCommand command;

    CommandsConstants(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public BasicCommand getCurrentCommand() {
        return command;
    }
}
