package special_char_bot.commands;
import com.google.common.collect.ImmutableMap;


public class CommandFactory {

    private static ImmutableMap<String, Command> nameToCommand;
    public CommandFactory(){
        Command startCmd = new StartCommand();
        nameToCommand = ImmutableMap.<String, Command>builder().
            put(startCmd.getCmdName(), startCmd).build();
    }

    /**
     * Return if the factory has a specific command
     *
     * @param cmdName to check if it exists in the factory
     * @return True if CmdName is in the factory.
     */
    public boolean hasCommand(String cmdName){
        return nameToCommand.containsKey(cmdName);
    }

    /**
     * Return the coresponding commad by command name
     *
     * @param cmdName
     * @return Command
     */
    public Command getCommand(String cmdName){
        return nameToCommand.get(cmdName);
    }
}
