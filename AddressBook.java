import java.util.Scanner;

public class AddressBook {
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

        // Getter methods
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

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
        String email = scanner.nextLine();

        Contact userContact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);


        System.out.println("\nContact Information:");
        System.out.println("First Name: " + userContact.getFirstName());
        System.out.println("Last Name: " + userContact.getLastName());
        System.out.println("Address: " + userContact.getAddress());
        System.out.println("City: " + userContact.getCity());
        System.out.println("State: " + userContact.getState());
        System.out.println("Zip Code: " + userContact.getZip());
        System.out.println("Phone Number: " + userContact.getPhoneNumber());
        System.out.println("Email: " + userContact.getEmail());

        scanner.close();
    }
}
