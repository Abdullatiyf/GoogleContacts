package uz.pdp;

import uz.pdp.entity.Contact;
import uz.pdp.entity.User;
import uz.pdp.memory.DynamicArray;
import uz.pdp.memory.Result;
import uz.pdp.payload.ContactDTO;
import uz.pdp.payload.ContactEditDTO;
import uz.pdp.payload.UserDTO;
import uz.pdp.service.ContactService;
import uz.pdp.service.UserService;

import java.util.Scanner;

public class Main {
    static User currentUser = null;
    static Contact selectedContact = null;

    static Scanner textScan = new Scanner(System.in);
    static Scanner numberScan = new Scanner(System.in);

    static UserService userService = new UserService();
    static ContactService contactService = new ContactService();

    public static void main(String[] args) {
        userMenu();
    }

    public static void userMenu() {
        while (true) {

            System.out.println("== USER MENU ==");
            System.out.println("0=>Exit, 1=>Login, 2=>Sign Up");
            switch (numberScan.nextInt()) {
                case 0:
                    return;
                case 1:
                    login();
                    if (currentUser != null) cabinetMenu();
                    break;
                case 2:
                    signUp();
                    if (currentUser != null) {
                        cabinetMenu();
                    }
                    break;
                default:
                    System.err.println("Command was wrong!");
                    break;

            }
        }
    }

    private static void cabinetMenu() {
        while (true) {
            System.out.println("== CABINET MENU ==");
            System.out.print("0=>Log Out, 1=>All Contacts, 2=>Add Contact, 3=>Search ");
            switch (numberScan.nextInt()) {
                case 0:
                    currentUser = null;
                    return;
                case 1:
                    DynamicArray<Contact> userContacts = contactService.getUserContacts(currentUser.getId());
                    selectContact(userContacts);

                    break;
                case 2:
                    createNewContact();
                    break;
                case 3:
                    System.out.println("Enter search text: ");
                    String searchText = textScan.nextLine();
                    DynamicArray<Contact> searchedContacts = contactService.search(currentUser.getId(), searchText);
                    selectContact(searchedContacts);
                    break;
                default:
                    System.out.println("Wrong operation");
            }


//            case 1: printContact();
        }
    }

    private static void selectedContactMenu() {
        Result result;
        while (true) {
            System.out.println("0=>Back, 1=>Edit, 2=>Remove");
            switch (numberScan.nextInt()) {
                case 0:
                    return;
                case 1:
                    ContactEditDTO editDTO = new ContactEditDTO();
                    System.out.print("Enter new full name: ");
                    editDTO.setFullName(textScan.nextLine());
                    System.out.print("Enter new Phone: ");
                    editDTO.setPhone(textScan.nextLine());
                    System.out.print("Enter new Email: ");
                    editDTO.setEmail(textScan.nextLine());
                    editDTO.setUserId(currentUser.getId());

                    result = contactService.edit(editDTO);
                    if (result.getSuccess()) {
                        selectedContact = null;
                        System.out.println(result.getMessage());
                        return;
                    } else {
                        System.err.println(result.getMessage());
                    }
                    break;
                case 2:
                    result = contactService.delete(selectedContact.getId());
                    if (result.getSuccess()) {
                        selectedContact = null;
                        System.out.println(result.getMessage());
                        return;
                    } else {
                        System.err.println(result.getMessage());
                    }
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }


    public static void signUp() {
        UserDTO userDTO = new UserDTO();
        System.out.print("Enter fullname: ");
        userDTO.setFullName(textScan.nextLine());
        System.out.print("Enter password: ");
        userDTO.setPassword(textScan.nextLine());
        System.out.print("Enter email: ");
        userDTO.setEmail(textScan.nextLine());
        System.out.print("Enter phone: ");
        userDTO.setPhone(textScan.nextLine());
        currentUser = userService.create(userDTO);


    }

    public static void login() {
        System.out.print("Enter email or phone: ");
        String emailOrPhone = textScan.nextLine();
        System.out.print("Enter password: ");
        String password = textScan.nextLine();
        currentUser = userService.get(emailOrPhone, password);

    }

    public static void printContact(Contact contact) {

    }

    private static void showUserContacts(DynamicArray<Contact> userContacts) {


        for (int i = 0; i < userContacts.size(); i++) {
            System.out.println((userContacts.get(i).getId()) + "=>" + userContacts.get(i));
        }
    }

    private static Contact getContactById(Long id, DynamicArray<Contact> userContacts) {
        for (int i = 0; i < userContacts.size(); i++) {
            if (userContacts.get(i).getId().equals(id)) {
                return userContacts.get(i);
            }
        }
        return null;
    }

    private static void createNewContact() {
        ContactDTO newContact = new ContactDTO();
        System.out.print("Enter full name: ");
        newContact.setFullName(textScan.nextLine());
        System.out.print("Enter phone: ");
        newContact.setPhone(textScan.nextLine());
        System.out.print("Enter email: ");
        newContact.setEmail(textScan.nextLine());
        System.out.print("Enter description: ");
        newContact.setDescription(textScan.nextLine());
        System.out.print("Enter Company: ");
        newContact.setCompany(textScan.nextLine());
        System.out.print("Enter Position: ");
        newContact.setPosition(textScan.nextLine());
        newContact.setUserId(currentUser.getId());
        Result result = contactService.create(newContact);
        if (result.getSuccess()) {
            System.out.println(result.getMessage());
        } else {
            System.err.println(result.getMessage());
        }
    }

    private static void selectContact(DynamicArray<Contact> contacts) {
        System.out.println("Contact tanlang(0=>Back): ");
        showUserContacts(contacts);
        Long id = numberScan.nextLong();
        if (id <= 0 || contacts.size() < id) {
            return;
        } else {
            selectedContact = getContactById(id, contacts);
            System.out.println("Selected contact=>" + selectedContact);
            selectedContactMenu();
        }
    }
}
