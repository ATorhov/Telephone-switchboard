package com.atorhoff.project.telefoneswitchboard.commands;

import com.atorhoff.project.telefoneswitchboard.commands.contracts.Command;
import com.atorhoff.project.telefoneswitchboard.core.contract.PhoneSwitchBoardRepository;
import com.atorhoff.project.telefoneswitchboard.utils.ValidationHelpers;

import java.util.List;

public class RemoveContactCommand implements Command {


    public static final int EXPECTED_PARAMETERS = 2;
    private static final String CONTACT_DOES_NOT_EXIST_MESSAGE = "Contact '%s' does not exist";
    private static final String CONTACT_DELETED = "Contact '%s' deleted";

    private final PhoneSwitchBoardRepository repository;

    public RemoveContactCommand(PhoneSwitchBoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentCounts(parameters, EXPECTED_PARAMETERS);
        String contactName = parameters.get(1);
        return deleteContact(contactName);
    }

    private String deleteContact(String contactName) {
        if (!repository.personExists(contactName)) {
            throw new IllegalArgumentException(String.format(CONTACT_DOES_NOT_EXIST_MESSAGE, contactName));
        }
        repository.removeContact(contactName);
        return String.format(CONTACT_DELETED, contactName);
    }
}