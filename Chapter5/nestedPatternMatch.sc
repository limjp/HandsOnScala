case class Person(name: String, title: String)

def greet(p: Person) = p match {
  case Person(s"$firstName $lastName", title) => println(s"Hello $title $lastName")
  case Person(name, title) => println(s"Hello $title $name")
}

def greet2(husband: Person, wife: Person) = (husband, wife) match {
  case(Person(s"$first1 $last1", _), Person(s"$first2 $last2", _)) if last1 == last2 => println(s"Hello Mr and Ms $last1")
  case (Person(name1, _), Person(name2, _)) => println(s"Hello $name1 and $name2")
}

greet2(Person("James Bond", "Mr"), Person("Jane Bond", "Ms"))

greet2(Person("James Bond", "Mr"), Person("Jane", "Ms"))