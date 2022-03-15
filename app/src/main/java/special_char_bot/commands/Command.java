package special_char_bot.commands;
import org.telegram.telegrambots.meta.api.objects.Update;


public abstract class Command {
    
    private final static int COMMAND_MAX_LENGTH = 32;

    /**
     * Get the name of this command
     *
     * @@return the cmdName
     */
    public abstract String getCmdName();

    /**
     * Get the description of this command
     *
     * @@return the description
     */
    public abstract String getCmdDesc();

    /**
     * Process the message and execute the command
     *
     * @param message the message to process
     */
    public abstract String call(Update update);

}
