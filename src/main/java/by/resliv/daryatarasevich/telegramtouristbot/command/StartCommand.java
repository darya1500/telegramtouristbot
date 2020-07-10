package by.resliv.daryatarasevich.telegramtouristbot.command;

import org.telegram.telegrambots.meta.TelegramBotsApi;

public class StartCommand implements BasicCommand {
    @Override
    public String execute() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        return "Здравствуйте! Меня зовут TelegramTouristBot! Я помогу Вам найти достопримечательности " +
                "для посещения в любом городе. Просто напишите названия города, который Вас интересует. " +
                "Например: Москва. ";
    }
}
