package service

import gt.service.AddressBookDao
import gt.service.AddressBookService
import gt.service.ContactParser
import spock.lang.Specification

class AddressBookServiceTest extends Specification{

    def parser = new ContactParser()
    def dao = new AddressBookDao(parser)
    def service = new AddressBookService(dao)

    def "should return number of males"() {
        when:
        def result = service.getNumberOfMales()

        then:
        result == 3
    }

    def "should return oldest person"() {
        when:
        def result = service.getOldestPerson()

        then:
        result == Optional.of("Wes Jackson")
    }

    def "should return days older difference between Bill and Paul"() {
        when:
        def result = service.getDaysOlder("Paul Robinson", "Bill McKnight")

        then:
        result == -2862
    }

    def "should return min long if date of birth info is not found"() {
        when:
        def result = service.getDaysOlder("John Robinson", "Bill McKnight")

        then:
        result == Long.MIN_VALUE
    }
}
