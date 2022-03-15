package special_char_bot;

import special_char_bot.commands.CommandFactory;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class SpecialCharBot extends TelegramLongPollingBot {
    private Config config;
    private CommandFactory commandFactory;
    private final String COMMAND_PREFIX = "/";

    public SpecialCharBot(){
        try{
            config = new Config("config.properties");
            commandFactory = new CommandFactory();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Return if the message is a command
     *
     * @param message_text to process
     * @@return True if message_text is a valid commad
     */
    private boolean isCommand(String message_text) {
        if (message_text.startsWith(COMMAND_PREFIX) && commandFactory.hasCommand(message_text.substring(1))){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Process received message
     *
     * @param update to process
     */
    @Override
    public void onUpdateReceived(Update update) {
        // check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().trim();
            String newMessageText = "";
            long chatId = update.getMessage().getChatId();
            if (isCommand(messageText)){
                newMessageText = commandFactory.getCommand(messageText.substring(1)).call(update);
            } else{
                newMessageText = getNameOfChar(messageText);
            }
            sendNewMessage(newMessageText, chatId);
        }
    }

    public String getNameOfChar(String messageText) {
        String newMessageText = "";
        if (messageText.length() == 1){
            char specialChar = messageText.charAt(0);
            int specialCharCodePoint = (int)specialChar;
            String specialCharName = Character.getName(specialCharCodePoint);  
            newMessageText = "The character '" + specialChar + "' has the unicode name as: " + specialCharName;
        } else {
            newMessageText = "Please input just one character one time, such as '&'.";
        }
        return newMessageText;
    }

    public boolean sendNewMessage(String messageText, long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(Long.toString(chatId));
        message.setText(messageText);
        try {
            execute(message); // Sending our message object to user
            return true;
        } catch (TelegramApiException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @SpecialCharBot, it must return 'MyAmazingBot'
        return config.botUsername;
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return config.botToken;
    }
}
