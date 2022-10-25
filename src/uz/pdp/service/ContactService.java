package uz.pdp.service;

import uz.pdp.entity.Contact;
import uz.pdp.memory.DynamicArray;
import uz.pdp.memory.Result;
import uz.pdp.payload.ContactDTO;
import uz.pdp.payload.ContactEditDTO;

public class ContactService implements ContactServiceInterface {

    @Override
    public Result create(ContactDTO contactDTO) {
        Result result = new Result();
        if (!hasUserContact(contactDTO)) {
            Contact contact = new Contact();
            contact.setPhone(contactDTO.getPhone());
            contact.setEmail(contactDTO.getEmail());
            contact.setCompany(contactDTO.getCompany());
            contact.setPosition(contactDTO.getPosition());
            contact.setDescription(contactDTO.getDescription());
            contact.setAddress(contactDTO.getAddress());
            contact.setFullname(contactDTO.getFullName());
            contact.setBirthDate(contactDTO.getBirthDate());
            contact.setUserId(contactDTO.getUserId());
            result.setSuccess(true);
            result.setMessage("New Contact has created successfully");
            contacts.add(contact);
        } else {
            result.setMessage("Contact was not created");
        }
        return result;
    }

    @Override
    public Contact get(Long id) {
        Contact contact;
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public Result edit(ContactEditDTO contactEditDTO) {
        Result result = new Result();
        Contact contact;
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            if (contact.getId().equals(contactEditDTO.getId())) {
                if (!contact.getId().equals(contactEditDTO.getId()) &&
                        !contact.getPhone().equals(contactEditDTO.getPhone())) {
                    contact.setPhone(contactEditDTO.getPhone());
                    contact.setEmail(contactEditDTO.getEmail());
                    contact.setFullname(contactEditDTO.getFullName());
                    result.setSuccess(true);
                    result.setMessage("Contact has edited successfully");
                }
            }
        }
        result.setMessage("Contact with " + contactEditDTO.getPhone() + " phone num is exists");
        return result;
    }

    @Override
    public Result delete(Long id) {
        Result result = new Result();
        Contact contact;
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            if (contact.getId().equals(id)) {
                result.setSuccess(contacts.remove(contact));
                result.setMessage("Contact has deleted successfully");
                return result;
            }
            result.setMessage("Contact not found or did not delete");
        }
        return result;
    }

    @Override
    public DynamicArray<Contact> search(Long userid, String text) {
        DynamicArray<Contact> result = new DynamicArray<>();
        Contact contact;
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            if (contact.getUserId().equals(userid) ||
                    contact.getEmail().equals(text) ||
                    contact.getFullname().equals(text)) {
                result.add(contact);
            }
        }
        return result;
    }

    @Override
    public DynamicArray<Contact> getUserContacts(Long userId) {
        DynamicArray<Contact> result = new DynamicArray<>();
        Contact contact;
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            if (contact.getUserId().equals(userId)) {
                result.add(contacts.get(i));
            }
        }
        return result;
    }

    private boolean hasUserContact(ContactDTO contactDTO) {
        Contact contact;
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            if (contact != null && contact.getUserId().equals(contactDTO.getUserId())
                    && contact.getPhone().equals(contactDTO.getPhone())) {
                return true;
            }
        }
        return false;
    }
}
