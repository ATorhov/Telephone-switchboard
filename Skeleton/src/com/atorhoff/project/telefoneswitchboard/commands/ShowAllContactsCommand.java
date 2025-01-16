package com.atorhoff.project.telefoneswitchboard.commands;

import com.atorhoff.project.telefoneswitchboard.commands.contracts.Command;
import com.atorhoff.project.telefoneswitchboard.core.contract.PhoneSwitchBoardRepository;
import com.atorhoff.project.telefoneswitchboard.model.contracts.Contact;
import com.atorhoff.project.telefoneswitchboard.utils.ValidationHelpers;

import java.util.List;

public class ShowAllContactsCommand implements Command {

    private final PhoneSwitchBoardRepository repository;

    public ShowAllContactsCommand(PhoneSwitchBoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentCounts(parameters, 1);
        return showAllContacts();
    }

    private String showAllContacts() {
        if (repository.getContacts().isEmpty()) {
            return "No contacts found";
        }
        StringBuilder result = new StringBuilder();
        for (Contact contact : repository.getContacts()) {
            result.append(contact);
        }
        return result.toString();
    }
}
