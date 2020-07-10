package by.resliv.daryatarasevich.telegramtouristbot.command;


public final class HelpCommand implements BasicCommand {
    @Override
    public String execute() {
        return "Я помогу Вам найти достопримечательности для посещения в любом городе. Просто напишите названия города, который Вас интересует. Например: Москва. ";
    }
}
