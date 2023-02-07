package gt;

import org.joda.time.LocalDate;

public record Contact (String name, Gender gender, LocalDate dateOfBirth) {
    
}
