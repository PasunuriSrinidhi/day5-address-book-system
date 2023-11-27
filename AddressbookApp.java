import java.io.IOException;
import java.util.*;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods for name and phoneNumber
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{name='" + name + "', phoneNumber='" + phoneNumber + "'}";
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void editPersonDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the contact you want to edit: ");
        String targetName = input.next();

        for (Contact contact : contacts) {
            if (contact.getName().equals(targetName)) {
                System.out.println("Enter the new name: ");
                String newName = input.next();
                contact.setName(newName);

                System.out.println("Enter the new phone number: ");
                String newPhoneNumber = input.next();
                contact.setPhoneNumber(newPhoneNumber);

                System.out.println("Contact details updated successfully.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    public void displayContact() {
        System.out.println("Contacts in Address Book:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void deleteContact() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the contact you want to delete: ");
        String targetName = input.next();

        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equals(targetName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}

public class AddressbookApp {
    public static void main(String[] args) throws IOException {
        HashMap<String, AddressBook> dictionary = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("Options are : ");
            System.out.print("1. Add Contact to existing address book\t");
            System.out.print("2. Edit Contact\t");
            System.out.print("3. Display Address Book\n");
            System.out.print("4. Delete Contact\t");
            System.out.print("5. Display available Address Books\t");
            System.out.print("6. Add new Address Book\n");

            System.out.print("7. Exit\n");
            System.out.print("Enter an option from above: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter name of address book in which you want to add contact: ");
                    String addressBookName = input.next();
                    if (dictionary.containsKey(addressBookName)) {
                        System.out.println(addressBookName + " Address book exists.");
                        AddressBook addressBook = dictionary.get(addressBookName);
                        System.out.println("Enter contact name: ");
                        String contactName = input.next();
                        System.out.println("Enter contact phone number: ");
                        String contactPhoneNumber = input.next();
                        addressBook.addContact(contactName, contactPhoneNumber);
                    } else {
                        System.out.println("Address Book does not exist");
                    }
                    break;
                case 2:
                    System.out.println("Enter name of address book in which you want to edit contact: ");
                    String addressBookName1 = input.next();
                    if (dictionary.containsKey(addressBookName1)) {
                        System.out.println(addressBookName1 + " Address book exists.");
                        AddressBook addressBook = dictionary.get(addressBookName1);
                        addressBook.editPersonDetails();
                    } else {
                        System.out.println("Address Book does not exist");
                    }
                    break;
                case 3:
                    System.out.println("Enter name of address book in which you want to display contact: ");
                    String addressBookName2 = input.next();
                    if (dictionary.containsKey(addressBookName2)) {
                        System.out.println(addressBookName2 + " Address book exists.");
                        AddressBook addressBook = dictionary.get(addressBookName2);
                        addressBook.displayContact();
                    } else {
                        System.out.println("Address Book does not exist");
                    }
                    break;
                case 4:
                    System.out.println("Enter name of address book in which you want to delete contact: ");
                    String addressBookName3 = input.next();
                    if (dictionary.containsKey(addressBookName3)) {
                        System.out.println(addressBookName3 + " Address book exists.");
                        AddressBook addressBook = dictionary.get(addressBookName3);
                        addressBook.deleteContact();
                    } else {
                        System.out.println("Address Book does not exist");
                    }
                    break;
                case 5:
                    if (dictionary.isEmpty()) {
                        System.out.println("Dictionary is empty");
                    } else {
                        System.out.println(dictionary.keySet());
                    }
                    break;
                case 6:
                    System.out.println("Enter name of address book you want to add to dictionary: ");
                    String addressBookName4 = input.next();
                    if (dictionary.containsKey(addressBookName4)) {
                        System.out.println(addressBookName4 + " Address book exists.");
                    } else {
                        System.out.println("Address Book does not exist");
                        AddressBook addressBook = new AddressBook();
                        dictionary.put(addressBookName4, addressBook);
                    }
                    break;
                case 7:
                    System.out.println("Exiting from dictionary");
                    break;
            }
        } while (option != 7);
    }
}
