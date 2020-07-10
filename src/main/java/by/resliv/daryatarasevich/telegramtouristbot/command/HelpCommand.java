package by.resliv.daryatarasevich.telegramtouristbot.command;


public final class HelpCommand implements BasicCommand {
    @Override
    public String execute() {
        return "TelegramTouristBot поможет Вам найти достопримечательности для посещения в любом городе. Просто напишите названия города, который Вас интересует. Например: Москва. ";
    }
}
