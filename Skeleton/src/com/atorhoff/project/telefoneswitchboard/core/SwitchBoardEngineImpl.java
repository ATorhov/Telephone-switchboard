package com.atorhoff.project.telefoneswitchboard.core;

import com.atorhoff.project.telefoneswitchboard.commands.contracts.Command;
import com.atorhoff.project.telefoneswitchboard.core.contract.CommandFactory;
import com.atorhoff.project.telefoneswitchboard.core.contract.Engine;
import com.atorhoff.project.telefoneswitchboard.core.contract.PhoneSwitchBoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwitchBoardEngineImpl implements Engine {

    private static final String TERMINATION_COMMAND = "Close";
    private static final String EMPTY_COMMAND = "Command cannot be empty";
    private static final String MAIN_SPLIT_SYMBOL = " ";
    private static final String STEPS_OPEN_COMMAND = "//*";
    private static final String STEPS_CLOSE_COMMAND = "*//";

    private final PhoneSwitchBoardRepository phoneSwitchBoardRepository;
    private final CommandFactory commandFactory;

    public SwitchBoardEngineImpl() {
        this.phoneSwitchBoardRepository = new PhoneSwitchBoardRepositoryImpl();
        this.commandFactory = new CommandFactoryImpl();
    }


    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.isBlank()) {
                    System.out.println(EMPTY_COMMAND);
                    continue;
                }
                if (input.equalsIgnoreCase(TERMINATION_COMMAND)) {
                    break;
                }
                processCommand(input);
            } catch (Exception ex) {
                if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
                    System.out.println(ex.getMessage());
                } else {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    private void processCommand(String input) {
        String commandName = extractCommandName(input);
        Command command = commandFactory.createCommandFromCommandName(commandName, phoneSwitchBoardRepository);
        List<String> parameters = extractCommandParameters(input);
        String commandResult = command.execute(parameters);
        System.out.println(commandResult);
    }

    private List<String> extractCommandParameters(String input) {
        String[] commandParts =input.split(MAIN_SPLIT_SYMBOL);
        ArrayList<String> parameters = new ArrayList<>();
        for (String commandPart : commandParts) {
            parameters.add(commandPart.trim());
        }
        return parameters;
    }

    private String extractCommandName(String input) {
        return input.split(MAIN_SPLIT_SYMBOL)[0];
    }
}
