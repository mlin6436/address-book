package gt

import spock.lang.Specification

class AddressBookDaoTest extends Specification {

    def "should return a list of contacts"() {
        setup:
        def filename = "AddressBook"
        def parser = new ContactParser()
        def dao = new AddressBookDao(parser)

        when:
        def result = dao.getContacts(filename)

        then:
        result.size() == 5
    }

    def "should return empty list when failed to retrieve contacts"() {
        setup:
        def filename = "AddressBook"
        def parser = Mock(ContactParser)
        def dao = new AddressBookDao(parser)

        when:
        def result = dao.getContacts(filename)

        then:
        1 * parser.parse(_) >> { throw new RuntimeException() }
        result.size() == 0
    }
}
