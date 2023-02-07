package gt;

import org.joda.time.Days;
import org.joda.time.LocalDate;

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

    public long getDaysOlder(String name1, String name2) {
        Optional<LocalDate> dob1 = contacts.stream()
            .filter(contact -> contact.name().equals(name1)).map(Contact::dateOfBirth).findFirst();
        Optional<LocalDate> dob2 = contacts.stream()
            .filter(contact -> contact.name().equals(name2)).map(Contact::dateOfBirth).findFirst();
        return Days.daysBetween(dob1.get(), dob2.get()).getDays();
    }
}
