package com.atorhoff.project.telefoneswitchboard.core.contract;

import com.atorhoff.project.telefoneswitchboard.model.contracts.Contact;

import java.util.List;

public interface PhoneSwitchBoardRepository {
    void addContact(String name, String phone);
    boolean personExists(String name);
    List<Contact> getContacts();
    Contact getContact(String contactName);

    void removeContact(String contactName);
}
