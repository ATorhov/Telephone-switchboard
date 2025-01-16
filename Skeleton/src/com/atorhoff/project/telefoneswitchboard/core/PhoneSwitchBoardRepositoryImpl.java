package com.atorhoff.project.telefoneswitchboard.core;

import com.atorhoff.project.telefoneswitchboard.core.contract.PhoneSwitchBoardRepository;
import com.atorhoff.project.telefoneswitchboard.model.contracts.Contact;
import com.atorhoff.project.telefoneswitchboard.model.contracts.Namable;
import com.atorhoff.project.telefoneswitchboard.model.entity.ContactImpl;

import java.util.ArrayList;
import java.util.List;

public class PhoneSwitchBoardRepositoryImpl implements PhoneSwitchBoardRepository {
    private final List<Contact> contacts;
    private static int nextId;


    public PhoneSwitchBoardRepositoryImpl() {
        nextId = 0;
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phone) {
        this.contacts.add(new ContactImpl(++nextId, name, phone));
    }

    @Override
    public boolean personExists(String name) {
        return elementExists(contacts, name);
    }

    @Override
    public List<Contact> getContacts() {
        return new ArrayList<>(this.contacts);
    }

    @Override
    public void removeContact(String contactName) {
        if (elementExists(contacts, contactName)) {
            contacts.remove(getContact(contactName));
        }
    }

    public Contact getContact(String contactName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(contactName)) {
                return contact;
            }
        }
        return null;
    }

    private <T extends Namable> boolean elementExists(List<T> list, String name) {
        for (T element : list) {
            if (element.getFirstName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
