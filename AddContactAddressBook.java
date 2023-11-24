import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddContactAddressBook {
    private static class Contact {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private Long zip;
        private Long phoneNumber;
        private String email;


        public Contact(String firstName, String lastName, String address, String city, String state,
                       Long zip, Long phoneNumber, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }


        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public Long getZip() {
            return zip;
        }

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }
    }

    private List<Contact> contacts;

    public AddContactAddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added to Address Book!");
    }

    public void displayContacts() {
        System.out.println("\nAddress Book Contents:");
        for (Contact contact : contacts) {
            System.out.println("\nContact Information:");
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
            System.out.println("Address: " + contact.getAddress());
            System.out.println("City: " + contact.getCity());
            System.out.println("State: " + contact.getState());
            System.out.println("Zip Code: " + contact.getZip());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email: " + contact.getEmail());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddContactAddressBook addressBook = new AddContactAddressBook();

        while (true) {
            System.out.print("Enter First Name (type 'exit' to stop): ");
            String firstName = scanner.nextLine();

            if (firstName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            System.out.print("Enter State: ");
            String state = scanner.nextLine();

            System.out.print("Enter Zip Code: ");
            Long zip = scanner.nextLong();

            System.out.print("Enter Phone Number: ");
            Long phoneNumber = scanner.nextLong();

            System.out.print("Enter Email: ");
            scanner.nextLine();
            String email = scanner.nextLine();


            Contact userContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);


            addressBook.addContact(userContact);
        }

        addressBook.displayContacts();


    }
}
