package dansapps.interakt.commands;

import dansapps.interakt.Interakt;
import preponderous.ponder.system.abs.ApplicationCommand;
import preponderous.ponder.system.abs.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel McCoy Stephenson
 * @since January 7th, 2022
 */
public class QuitCommand extends ApplicationCommand {

    public QuitCommand() {
        super(new ArrayList<>(List.of("quit")), new ArrayList<>(List.of("interakt.quit")));
    }

    @Override
    public boolean execute(CommandSender sender) {
        sender.sendMessage("Goodbye!");
        Interakt.getInstance().onShutdown();
        System.exit(0);
        return true;
    }

    @Override
    public boolean execute(CommandSender sender, String[] strings) {
        return execute(sender);
    }
}