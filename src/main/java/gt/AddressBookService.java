package gt;

import java.util.List;

public class AddressBookService {

    private final String filename = "AddressBook";
    private final List<Contact> contacts;

    public AddressBookService(AddressBookDao dao) {
        this.contacts = dao.getContacts(filename);
    }

    public long getNumberOfMales() {
        return contacts.stream().filter(contact -> contact.gender() == Gender.Male).count();
    }
}
