package gt;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookDao {

    private final ContactParser parser;

    public AddressBookDao(ContactParser parser) {
        this.parser = parser;
    }

    public List<Contact> getContacts(String filename) throws Exception {
        URI uri = ClassLoader.getSystemResource(filename).toURI();
        Path path = Paths.get(uri);
        List<String> lines = Files.readAllLines(path);
        return lines.stream().map(line -> {
            try {
                return parser.parse(line);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
