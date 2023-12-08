import java.util.*;
import java.util.HashMap;

public class AddressBookProgram {

    static Scanner sc = new Scanner(System.in);
    static ContactFunctions contactFunctions = new ContactFunctions();
    static HashMap<String, ArrayList<ContactItems>> contactItemsDict = new HashMap<>();
    static AddressBookProgram addressBookProgram = new AddressBookProgram();
    static ArrayList<ContactItems> contactList = new ArrayList<>();

    // Main method
    public static void main(String[] args) {

        System.out.println("Welcome to the Address book program"); // Welcome statement
        addressBookProgram.addContactList();
    }

    public void addAddressBook() {
        System.out.println("Enter address book name :");
        String addressBookName = sc.next();
        ArrayList<ContactItems> contactList = new ArrayList<>();
        contactItemsDict.put(addressBookName, contactList);
    }

    public ArrayList selectAddressBook() {
        System.out.println("Enter the name of address book");
        String name = sc.nextLine();
        if (contactItemsDict.containsKey(name)) {
            ArrayList<ContactItems> contactItems = contactItemsDict.get(name);
            return contactItems;
        }
        System.out.println("not found");
        return null;
    }

    // UC7: method to check for duplicate entry
    public boolean hasDuplicate(String first_name) {
        return this.addressbook.containsKey(first_name.toLowerCase().trim());
    }
    public void displayList() {
        for (Map.Entry m : contactItemsDict.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
    // UC8: method to get all contacts by city
    public ArrayList<Contact> getAllbyCity(String city) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (Entry<String, Contact> entry : this.addressbook.entrySet()) {
            if (entry.getValue().city.equals(city)) {
                contacts.add(entry.getValue());
            }
        }
        return contacts;
    }

    // UC8: method to get all contacts by state
    public ArrayList<Contact> getAllbyState(String state) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (Entry<String, Contact> entry : this.addressbook.entrySet()) {
            if (entry.getValue().state.equals(state)) {
                contacts.add(entry.getValue());
            }
        }
        return contacts;
    }

    //Display Menu Option
    public void addContactList() {
        int option = 0;
        while (option != 3) {
            System.out.println("Press 0 - Display all address books");
            System.out.println("Press 1 - Add new address book");
            System.out.println("Press 2 - Access address book");
            System.out.println("Press 3 - Exit");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 0 -> displayList();
                case 1 -> addressBookProgram.addAddressBook();
                case 2 -> {
                    addressBookProgram.selectAddressBook();
                    System.out.println("Press 0 - Display all contacts");
                    System.out.println("Press 1 - Add contact");
                    System.out.println("Press 2 - Edit contact");
                    System.out.println("Press 3 - Delete contact");
                    System.out.println("Press 4- Check for duplicate");
                    System.out.println("Enter choice");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 0 -> contactFunctions.display(contactList);
                        case 1 -> contactFunctions.addContact(contactList);
                        case 2 -> contactFunctions.editContact(contactList);
                        case 3 -> contactFunctions.deleteContact(contactList);
                        case 4 -> contactFunctions.hasDuplicate(contactList);    
                        case 5 -> contactFunctions.getAllbyCity(city);   
                        case 6 -> contactFunctions.getAllbyState(state);  
                        
                    }
                }
            }
        }
    }
}
