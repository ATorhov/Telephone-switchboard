package com.atorhoff.project.telefoneswitchboard.core;

import com.atorhoff.project.telefoneswitchboard.core.contract.PhoneSwitchBoardRepository;
import com.atorhoff.project.telefoneswitchboard.model.contracts.Contact;
import com.atorhoff.project.telefoneswitchboard.model.contracts.Namable;
import com.atorhoff.project.telefoneswitchboard.model.entity.ContactImpl;

import java.util.ArrayList;
import java.util.List;

public class PhoneSwitchBoardRepositoryImpl implements PhoneSwitchBoardRepository {
    private final List<Contact> contacts;


    public PhoneSwitchBoardRepositoryImpl() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phone) {
        this.contacts.add(new ContactImpl(name, phone));
    }

    @Override
    public boolean personExists(String name) {
        return elementExists(contacts, name);
    }

    @Override
    public List<Contact> getContacts() {
        return new ArrayList<>(this.contacts);
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
