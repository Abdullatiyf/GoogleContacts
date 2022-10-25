package uz.pdp.service;

import uz.pdp.entity.Contact;
import uz.pdp.memory.DynamicArray;
import uz.pdp.memory.Result;
import uz.pdp.payload.ContactDTO;
import uz.pdp.payload.ContactEditDTO;

public interface ContactServiceInterface {
    DynamicArray<Contact> contacts = new DynamicArray<>();

    Result create(ContactDTO contactDTO);

    Contact get(Long id);

    Result edit(ContactEditDTO contactEditDTO);

    Result delete(Long id);

    DynamicArray<Contact> search(Long userid, String text);

    DynamicArray<Contact> getUserContacts(Long userId);
}
