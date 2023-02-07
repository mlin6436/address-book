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
}
