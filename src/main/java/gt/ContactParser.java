package gt;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ContactParser {

    private final DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("dd/MM/yy");

    public Contact parse(String input) {
        try {
            String[] tokens = input.split(",");
            String name = tokens[0];
            Gender gender = Gender.valueOf(tokens[1].trim());
            LocalDate dateOfBirth = dateTimeFormat.parseLocalDate(tokens[2].trim());
            return new Contact(name, gender, dateOfBirth);
        } catch (Exception e) {
            throw new RuntimeException("unable to parse input + " + e.getMessage());
        }
    }
}
