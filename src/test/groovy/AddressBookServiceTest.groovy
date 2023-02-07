package gt

import spock.lang.Specification

class AddressBookServiceTest extends Specification{

    def "should return number of males"() {
        setup:
        def parser = new ContactParser()
        def dao = new AddressBookDao(parser)
        def service = new AddressBookService(dao)

        when:
        def result = service.getNumberOfMales()

        then:
        result == 3
    }

    def "should return oldest person"() {
        setup:
        def parser = new ContactParser()
        def dao = new AddressBookDao(parser)
        def service = new AddressBookService(dao)

        when:
        def result = service.getOldestPerson()

        then:
        result == Optional.of("Wes Jackson")
    }

    def "should return days older difference between Bill and Paul"() {
        setup:
        def parser = new ContactParser()
        def dao = new AddressBookDao(parser)
        def service = new AddressBookService(dao)

        when:
        def result = service.getDaysOlder()

        then:
        result == -2862
    }
}
