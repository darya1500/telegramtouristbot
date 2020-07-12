package by.resliv.daryatarasevich.telegramtouristbot.bot;

import by.resliv.daryatarasevich.telegramtouristbot.command.BasicCommand;
import by.resliv.daryatarasevich.telegramtouristbot.command.CommandFactory;
import by.resliv.daryatarasevich.telegramtouristbot.command.GeneralCommand;
import by.resliv.daryatarasevich.telegramtouristbot.exception.NoSuchCityException;
import by.resliv.daryatarasevich.telegramtouristbot.util.MessageConstants;
import by.resliv.daryatarasevich.telegramtouristbot.util.ValidationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.List;

/**
 * Telegram tourist bot class.
 *
 * @author darya tarasevich
 */
public class TouristBot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String token;
    @Value("${bot.name}")
    private String name;
    private static final Logger log = LogManager.getLogger(TouristBot.class);

    public TouristBot(DefaultBotOptions options) {
        super(options);
    }

    /**
     * This method is called when receiving updates via GetUpdates method.
     * Depending on having CallbackQuery processing scenario differs.
     *
     * @param update
     */
    @Override
    public void onUpdateReceived(Update update) {
        BasicCommand command;
        if (ValidationUtil.validate(update.getMessage())) {
            try {
                command = CommandFactory.defineCommand(update);
                sendMsg(update.getMessage().getChatId(), command.perform());
            } catch (NoSuchCityException | NullPointerException e) {
                log.debug(e);
                command = GeneralCommand.defaultCommand(update.getMessage().getText());
                try {
                    sendMsg(update.getMessage().getChatId(), command.perform());
                } catch (NoSuchCityException ex) {
                    log.error(ex);
                }
            }
        } else if (update.hasCallbackQuery()) {
            try {
                command = CommandFactory.defineCommand(update);
                sendMsg(update.getCallbackQuery().getMessage().getChatId(),
                        String.valueOf(command.perform()));
            } catch (NoSuchCityException e) {
                log.error(e);
            }
        }
    }

    /**
     * To send message with reply to user.
     *
     * @param chatId
     * @param s
     */
    public synchronized void sendMsg(long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        setInline(sendMessage);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e);
        }
    }

    /**
     * To create onscreen keyboard.
     *
     * @param sendMessage
     */
    private void setInline(SendMessage sendMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(MessageConstants.HELP);
        button.setCallbackData(MessageConstants.HELP2);
        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(button);
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(keyboardButtonsRow);
        inlineKeyboardMarkup.setKeyboard(buttons);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setName(String name) {
        this.name = name;
    }
}
