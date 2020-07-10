package by.resliv.daryatarasevich.telegramtouristbot;

import by.resliv.daryatarasevich.telegramtouristbot.bot.TouristBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

//@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        new TouristBot().connect();


       // SpringApplication.run(Application.class, args);

    }
}
