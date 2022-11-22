import arrow.optics.Lens
import arrow.optics.Setter

data class Person(val name: String, val city: City)
data class City(val name: String, val street: Street)
data class Street(val name: String)

val citySetter: Setter<Person, City> = Setter { person, city ->
    person.copy(city = city(person.city))
}

val streetSetter: Setter<City, Street> = Setter { city, street ->
    city.copy(street = street(city.street))
}

val streetNameSetter: Setter<Street, String> = Setter{ street, name ->
    street.copy(name = name(street.name))
}


val personStreetNameSetter = citySetter compose streetSetter compose streetNameSetter

var person = Person("MyName", City("MyCity", Street("MyStreet")))
val person2 = personStreetNameSetter.modify(person) { "Banani" }

