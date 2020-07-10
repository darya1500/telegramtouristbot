package by.resliv.daryatarasevich.telegramtouristbot.bot;

import by.resliv.daryatarasevich.telegramtouristbot.command.CommandFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.List;

public class TouristBot extends TelegramLongPollingBot {
    private String token = "1379659363:AAFef_wY_4KOJx2iP0b4wgdnTlkUYYrKymk";
    private String botUsername = "TelegramTouristBot";

    // Тут будет то, что выполняется при получении сообщения
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message!=null&&message.hasText()) {
            try {
                long chatId = message.getChatId();
                String reply = CommandFactory.defineCommand(message.getText()).execute();
                sendMsg(chatId, reply);
            } catch (Exception e) {//TelegramApiException e) {
                //todo log
            }
        }
        else if (update.hasCallbackQuery()) {
                String reply = CommandFactory.defineCommand(update.getCallbackQuery().getData()).execute();
//                SendMessage sendMessage=new SendMessage().setText(reply)
//                        .setChatId(update.getCallbackQuery().getMessage().getChatId());
                sendMsg(update.getCallbackQuery().getMessage().getChatId(), reply);

        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    /**
     * To connect telegram tourist bot.
     */
    public void connect() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        //todo log
        try {
            telegramBotsApi.registerBot(this);
            //todo log
        } catch (TelegramApiRequestException e) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                //todo log
                return;
            }
            connect();
        }
    }

    /**
     * Метод для настройки сообщения и его отправки.
     *
     * @param chatId id чата
     * @param s      Строка, которую необходимо отправить в качестве сообщения.
     */
    public synchronized void sendMsg(long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);

setInline2(sendMessage);
       // setButtons(sendMessage);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo log
            // log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

//    //to create keyboard
//    public synchronized void setButtons(SendMessage sendMessage) {
//
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
//        KeyboardRow keyboardFirstRow = new KeyboardRow();
//        keyboardFirstRow.add(new KeyboardButton("Искать"));
//        KeyboardRow keyboardSecondRow = new KeyboardRow();
//        keyboardSecondRow.add(new KeyboardButton("Помощь"));
//        KeyboardRow keyboardThirdRow = new KeyboardRow();
//        keyboardSecondRow.add(new KeyboardButton("Выйти"));
//
//        keyboard.add(keyboardFirstRow);
//        keyboard.add(keyboardSecondRow);
//        keyboard.add(keyboardThirdRow);
//
//        replyKeyboardMarkup.setKeyboard(keyboard);
//    }

    //to create keybord on the screen
    private void setInline2(SendMessage sendMessage) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        InlineKeyboardButton button1 = new InlineKeyboardButton();
//        button1.setText("Найти");
//        button1.setCallbackData("/find");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Помощь");
        button2.setCallbackData("/help");
//        InlineKeyboardButton button3 = new InlineKeyboardButton();
//        button3.setText("Выйти");
//        button3.setCallbackData("/stop");
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        //keyboardButtonsRow1.add(button1);
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(button2);
        //keyboardButtonsRow2.add(button3);
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(keyboardButtonsRow1);
        buttons.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(buttons);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
    }

//    public synchronized void answerCallbackQuery(String callbackId, String message) {
//        AnswerCallbackQuery answer = new AnswerCallbackQuery();
//        answer.setCallbackQueryId(callbackId);
//        answer.setText(message);
//        answer.setShowAlert(true);
//        try {
//            answerCallbackQuery(answer);
//        } catch (TelegramApiException e) {
//            //todo
//        }
//    }


}
