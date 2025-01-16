package com.atorhoff.project.telefoneswitchboard.core.contract;

import com.atorhoff.project.telefoneswitchboard.commands.contracts.Command;

public interface CommandFactory {
    public Command createCommandFromCommandName(String commandName, PhoneSwitchBoardRepository repository);
}
