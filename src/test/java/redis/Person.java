package redis;

import java.io.Serializable;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:a.abdelfatah@live.com">Ahmed Kamal</a>
 * @since 23.01.16 09:17
 */
   public class Person implements Serializable {
        public Person(String name, int age, String phone, boolean isMarried) {
            this.name = name;
            this.age = age;
            this.phone = phone;
            this.isMarried = isMarried;
        }

        public String name;
        public int age;
        public String phone;
        public boolean isMarried;

        public static void assertEqualsForPerson(Person current, Person retrieved) {
            assertEquals(current.name, retrieved.name);
            assertEquals(current.age, retrieved.age);
            assertEquals(current.phone, retrieved.phone);
            assertEquals(current.isMarried, retrieved.isMarried);
        }

        public static Person createPersonAdam() {
            Person person = new Person("Adam", 20, "+343424324324", false);
            return person;
        }

        public static Person createPersonSara() {
            Person person = new Person("Sara", 24, "+211111124", true);
            return person;
        }

        public static Person createPersonSteve() {
            Person person = new Person("Steve", 50, "+00604400900", true);
            return person;
        }

    public static ArrayList<Person> getPersonList() {
        ArrayList<Person> personList = new ArrayList<>();

        personList.add(Person.createPersonAdam());
        personList.add(Person.createPersonSara());
        personList.add(Person.createPersonSteve());

        return personList;
    }
}
