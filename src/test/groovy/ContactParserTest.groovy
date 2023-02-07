package gt

import spock.lang.Specification

class ContactParserTest extends Specification {

    def "should parse and return Contact"() {
        setup:
        def input = "Bill McKnight, Male, 16/03/77"
        def parser = new ContactParser()

        when:
        def result = parser.parse(input)

        then:
        result.name == "Bill McKnight"
        result.gender == Gender.Male
        result.dateOfBirth.year == 1977
        result.dateOfBirth.monthValue == 3
        result.dateOfBirth.dayOfMonth == 16
    }
}
