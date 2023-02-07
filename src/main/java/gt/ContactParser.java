package gt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContactParser {

    public Contact parse(String input) {
        String[] tokens = input.split(",");
        String name = tokens[0];
        Gender gender = Gender.valueOf(tokens[1].trim());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate parsedDateOfBirth = LocalDate.parse(tokens[2].trim(), formatter);
        LocalDate dateOfBirth = parsedDateOfBirth.isAfter(LocalDate.now()) ?
            parsedDateOfBirth.minusYears(100) : parsedDateOfBirth;
        return new Contact(name, gender, dateOfBirth);
    }
}
