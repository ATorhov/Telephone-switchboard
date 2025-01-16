package com.atorhoff.project.telefoneswitchboard.core;

import com.atorhoff.project.telefoneswitchboard.commands.AddContactCommand;
import com.atorhoff.project.telefoneswitchboard.commands.RemoveContactCommand;
import com.atorhoff.project.telefoneswitchboard.commands.ShowAllContactsCommand;
import com.atorhoff.project.telefoneswitchboard.commands.contracts.Command;
import com.atorhoff.project.telefoneswitchboard.commands.enums.CommandType;
import com.atorhoff.project.telefoneswitchboard.core.contract.CommandFactory;
import com.atorhoff.project.telefoneswitchboard.core.contract.PhoneSwitchBoardRepository;

public class CommandFactoryImpl implements CommandFactory {

    private static final String COMMAND_NOT_SUPPORTED_MESSAGE = "Command %s is not supported";

    public Command createCommandFromCommandName(String commandName, PhoneSwitchBoardRepository repository) {
        switch (commandName) {
            case "ADDCONTACT":
                return new AddContactCommand(repository);
            case "SHOWALLCONTACTS":
                return new ShowAllContactsCommand(repository);
            case "REMOVECONTACT":
                return new RemoveContactCommand(repository);
            default:
                throw new IllegalArgumentException("Unknown command: " + commandName);
        }
    }

    private CommandType tryParseCommandType(String commandName) {
        try {
            return CommandType.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(COMMAND_NOT_SUPPORTED_MESSAGE, commandName));
        }
    }
}
