import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private long chat_id;
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    String lastMessage = "";

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {

        update.getUpdateId();
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        chat_id = update.getMessage().getChatId();

        String text = update.getMessage().getText();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            sendMessage.setText(getMessage(text));
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    public String getMessage(String msg) throws FileNotFoundException, TelegramApiException {
        ArrayList<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        if (msg.equals("Привет") || msg.equals("Меню")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("O'zbek tili");
            keyboardFirstRow.add("Русский язык");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";

        }


        if (msg.equals("O'zbek tili")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Erkaklar");
            keyboardFirstRow.add("Ayollar");
            keyboardFirstRow.add("Bolalar");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";
        }
        if (msg.equals("Русский язык")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Мужчина");
            keyboardFirstRow.add("Женшина");
            keyboardFirstRow.add("Дети");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";
        }

        if (msg.equals("Erkaklar")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Uzuklar");
            keyboardFirstRow.add("Zanjirlar");
            keyboardFirstRow.add("Breloklar");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";
        }
        if (msg.equals("Ayollar")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Uzuklar");
            keyboardFirstRow.add("Zanjirlar");
            keyboardFirstRow.add("Breloklar");
            keyboardFirstRow.add("Komplekt");
            keyboardFirstRow.add("Halqalar");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";
        }
        if (msg.equals("Bolalar")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Uzuklar");
            keyboardFirstRow.add("Zanjirlar");
            keyboardFirstRow.add("Breloklar");
            keyboardFirstRow.add("Komplekt");
            keyboardFirstRow.add("Halqalar");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";
        }
        if (msg.equals("Мужчина")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Кольца");
            keyboardFirstRow.add("Браслеты");
            keyboardFirstRow.add("Брелок");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";
        }
        if (msg.equals("Женшина")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Кольца");
            keyboardFirstRow.add("Браслеты");
            keyboardFirstRow.add("Брелок");
            keyboardFirstRow.add("Серьги");
            keyboardFirstRow.add("Комплекты");
            keyboardFirstRow.add("Подвески");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";
        }
        if (msg.equals("Дети")) {
            keyboard.clear();
            keyboardFirstRow.clear();
            keyboardFirstRow.add("Кольца");
            keyboardFirstRow.add("Браслеты");
            keyboardFirstRow.add("Брелок");
            keyboardFirstRow.add("Серьги");
            keyboardFirstRow.add("Комплекты");
            keyboardFirstRow.add("Подвески");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выбрать....";
        }
        if (msg.equals("Uzuklar")) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(chat_id);
            sendPhoto.setPhoto("https://imbt.ga/8XyAbx5c2B");
            execute(sendPhoto);
            return "Выбрать....";
        }

        return msg;
    }


    public String getBotUsername() {
        return "sasdasdasbot";
    }

    public String getBotToken() {
        return "1107696260:AAG34fI_WRTl0v5p7JLPGW2tCYcl63Pcd_g";
    }
}
