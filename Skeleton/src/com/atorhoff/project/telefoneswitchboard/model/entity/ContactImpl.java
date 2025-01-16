package com.atorhoff.project.telefoneswitchboard.model.entity;

import com.atorhoff.project.telefoneswitchboard.model.contracts.Contact;
import com.atorhoff.project.telefoneswitchboard.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class ContactImpl implements Contact {

    private static final int NAME_MIN_LENGTH = 5;
    private static final int NAME_MAX_LENGTH = 15;
    private static final int COMPANY_MIN_LENGTH = 3;
    private static final int COMPANY_MAX_LENGTH = 20;
    private static final int EMAIL_MIN_LENGTH = 5;
    private static final int EMAIL_MAX_LENGTH = 25;

    private int id;
    private String firstName;
    private String lastName;
    private String company;
    private String phone;
    private String businessPhone;
    private String email;
    private final List<String> notes;
    private final List<Contact> contacts;

    public ContactImpl(int id, String firstName, String phone) {
        this.id = id;
        setFirstName(firstName);
        setPhone(phone);
        contacts = new ArrayList<>();
        notes = new ArrayList<>();
    }

    public ContactImpl(int id, String firstName, String lastName, String company, String phone, String businessPhone, String email) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setCompany(company);
        setPhone(phone);
        setBusinessPhone(businessPhone);
        setEmail(email);
        contacts = new ArrayList<>();
        notes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        ValidationHelpers.validateStringLength(firstName, NAME_MIN_LENGTH, NAME_MAX_LENGTH,
                "The first name length must be between "
                        + NAME_MIN_LENGTH + " and "
                        + NAME_MAX_LENGTH + " symbols");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        ValidationHelpers.validateStringLength(lastName, NAME_MIN_LENGTH, NAME_MAX_LENGTH,
                "The last name length must be between "
                        + NAME_MIN_LENGTH + " and "
                        + NAME_MAX_LENGTH + " symbols");
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        ValidationHelpers.validateStringLength(company, COMPANY_MIN_LENGTH, COMPANY_MAX_LENGTH,
                "The company name length must be between "
                        + COMPANY_MIN_LENGTH + " and "
                        + COMPANY_MAX_LENGTH + " symbols");
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        ValidationHelpers.validateStringLength(email, EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH,
                "The email length must be between "
                        + EMAIL_MIN_LENGTH + " and "
                        + EMAIL_MAX_LENGTH + " symbols");
        this.email = email;
    }

    public List<String> getNotes() {
        return notes;
    }

    @Override
    public List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public String toString() {
        return "Contacts: {" +
                "ID "+getId()+
                " First name='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
