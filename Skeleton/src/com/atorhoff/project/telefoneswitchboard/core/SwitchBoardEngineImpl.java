package com.atorhoff.project.telefoneswitchboard.core;

import com.atorhoff.project.telefoneswitchboard.core.contract.Engine;

import java.util.Scanner;

public class SwitchBoardEngineImpl implements Engine {

    private static final String TERMINATION_COMMAND = "Close";
    private static final String EMPTY_COMMAND = "Command cannot be empty";
    private static final String MAIN_SPLIT_SYMBOL = " ";
    private static final String STEPS_OPEN_COMMAND = "//*";
    private static final String STEPS_CLOSE_COMMAND = "*//";

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

    }

    private String extractCommandName(String input) {
        return input.split(MAIN_SPLIT_SYMBOL)[0];
    }
}
