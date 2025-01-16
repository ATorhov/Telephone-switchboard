package com.atorhoff.project.telefoneswitchboard.model.contracts;

import java.util.List;

public interface Contact extends Namable, Identifiable{

    List<Contact> getContacts();
    void addContact(Contact contact);
    void removeContact(Contact contact);

}
