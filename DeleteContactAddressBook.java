import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DeleteContactAddressBook {
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

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setZip(Long zip) {
            this.zip = zip;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    private List<Contact> contacts;

    public DeleteContactAddressBook() {
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

    public void editContact(String firstName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (firstName.equals(contact.getFirstName())) {
                System.out.println("Choose field you want to edit:");
                System.out.println("1. First Name\t2. Last Name\t3. Address\t4. City\t5. State\t6. Zip Code\t7. Phone Number\t8. Email\t");

                Scanner scanner = new Scanner(System.in);

                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Enter new First Name:");
                        contact.setFirstName(scanner.next());
                        break;
                    case 2:
                        System.out.println("Enter new Last Name:");
                        contact.setLastName(scanner.next());
                        break;
                    case 3:
                        System.out.println("Enter Address:");
                        contact.setAddress(scanner.next());
                        break;
                    case 4:
                        System.out.println("Enter City:");
                        contact.setCity(scanner.next());
                        break;
                    case 5:
                        System.out.println("Enter State:");
                        contact.setState(scanner.next());
                        break;
                    case 6:
                        System.out.println("Enter new Zip:");
                        contact.setZip(scanner.nextLong());
                        break;
                    case 7:
                        System.out.println("Enter new Phone Number:");
                        contact.setPhoneNumber(scanner.nextLong());
                        break;
                    case 8:
                        System.out.println("Enter new Email:");
                        contact.setEmail(scanner.next());
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        }
    }

    public void deleteContact(String firstName) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (firstName.equals(contact.getFirstName())) {
                iterator.remove(); // Remove the contact if first name matches
                System.out.println("Contact deleted successfully.");
                return; // Exit the method once the contact is deleted
            }
        }
        System.out.println("Contact not found with the given first name.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeleteContactAddressBook addressBook = new DeleteContactAddressBook();

        int choice;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Contact\t2. Edit Contact\t3. Delete Contact\t4. Display Contacts\t5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.next();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.next();

                    System.out.print("Enter Address: ");
                    String address = scanner.next();

                    System.out.print("Enter City: ");
                    String city = scanner.next();

                    System.out.print("Enter State: ");
                    String state = scanner.next();

                    System.out.print("Enter Zip Code: ");
                    Long zip = scanner.nextLong();

                    System.out.print("Enter Phone Number: ");
                    Long phoneNumber = scanner.nextLong();

                    System.out.print("Enter Email: ");
                    String email = scanner.next();

                    Contact userContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    addressBook.addContact(userContact);
                    break;

                case 2:
                    System.out.print("Enter First Name to edit a contact: ");
                    String editFirstName = scanner.next();
                    addressBook.editContact(editFirstName);
                    break;

                case 3:
                    System.out.print("Enter First Name to delete a contact: ");
                    String deleteFirstName = scanner.next();
                    addressBook.deleteContact(deleteFirstName);
                    break;

                case 4:
                    addressBook.displayContacts();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }

        } while (choice != 5);


        addressBook.displayContacts();

        scanner.close();
    }
}
