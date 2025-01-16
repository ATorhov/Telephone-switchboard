package com.atorhoff.project.telefoneswitchboard.commands;

import com.atorhoff.project.telefoneswitchboard.commands.contracts.Command;
import com.atorhoff.project.telefoneswitchboard.core.contract.PhoneSwitchBoardRepository;
import com.atorhoff.project.telefoneswitchboard.utils.ValidationHelpers;

import java.util.List;

public class AddContactCommand implements Command {

    public static final int EXPECTED_PARAMETERS = 3;
    private static final String CONTACT_EXISTS_MESSAGE = "Contact '%s' already exists";
    private static final String CONTACT_CREATED = "Contact '%s' created";

    private final PhoneSwitchBoardRepository repository;

    public AddContactCommand(PhoneSwitchBoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentCounts(parameters, EXPECTED_PARAMETERS);
        String contactName = parameters.get(1);
        String contactNumber = parameters.get(2);
        return createContact(contactName, contactNumber);
    }

    private String createContact(String contactName, String contactNumber) {
        if (repository.personExists(contactName)) {
            throw new IllegalArgumentException(String.format(CONTACT_EXISTS_MESSAGE, contactName));
        };
        repository.addContact(contactName, contactNumber);
        return String.format(CONTACT_CREATED, contactName);
    }

}
