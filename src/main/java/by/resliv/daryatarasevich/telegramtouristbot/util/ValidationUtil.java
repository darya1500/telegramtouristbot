package by.resliv.daryatarasevich.telegramtouristbot.util;

import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * Validation class.
 *
 * @author darya tarasevich
 */
public class ValidationUtil {

    /**
     * To validate message is not empty.
     *
     * @param message
     * @return true if message has text
     */
    public static boolean validate(Message message){
        if (message!=null&&message.hasText()){
            return true;
        }
        return false;
    }
}
