package gt;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AddressBookService {

    private final String filename = "AddressBook";
    private final List<Contact> contacts;

    public AddressBookService(AddressBookDao dao) {
        this.contacts = dao.getContacts(filename);
    }

    public long getNumberOfMales() {
        return contacts.stream().filter(contact -> contact.gender() == Gender.Male).count();
    }

    public Optional<String> getOldestPerson() {
        return contacts.stream().sorted(Comparator.comparing(Contact::dateOfBirth)).map(Contact::name).findFirst();
    }
}
