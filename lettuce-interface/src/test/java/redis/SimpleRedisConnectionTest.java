package redis;

import org.junit.Before;
import org.junit.Test;

import static redis.Person.assertEqualsForPerson;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:a.abdelfatah@live.com">Ahmed Kamal</a>
 * @since 12.01.16 09:17
 */
public class SimpleRedisConnectionTest extends AbstractTest{

    SimpleRedisConnection redisConnection;

    @Before
    public void setUp() {
        redisConnection = new SimpleRedisConnection(client);
        redisConnection.clearAll();
    }

    @Test
    public void testCachePersonAndGetIt() {
        Person person = Person.createPersonAdam();
        boolean succeeded = redisConnection.cache("People", "Adam", person);
        assertEquals(succeeded, true);

        Person retrievedPerson = redisConnection.get("People", "Adam");
        Person.assertEqualsForPerson(person, retrievedPerson);
    }

    @Test
    public void testCachePersonList() {
        ArrayList<Person> personList = Person.getPersonList();

        boolean succeeded = redisConnection.cache("People", "PeopleList", personList);
        assertEquals(succeeded, true);
    }

    @Test
    public void testCachePersonListAndGetThem() {
        ArrayList<Person> personList = new ArrayList<>();

        personList.add(Person.createPersonAdam());
        personList.add(Person.createPersonSara());
        personList.add(Person.createPersonSteve());

        boolean succeeded = redisConnection.cache("People", "PeopleList", personList);
        assertEquals(succeeded, true);

        ArrayList<Person> retrievedPersonList = redisConnection.get("People", "PeopleList");

        assertEqualsForPerson(retrievedPersonList.get(0), Person.createPersonAdam());
        assertEqualsForPerson(retrievedPersonList.get(1), Person.createPersonSara());
        assertEqualsForPerson(retrievedPersonList.get(2), Person.createPersonSteve());
    }

    @Test
    public void testCachePersonAndClearIt() {
        Person person = Person.createPersonAdam();
        boolean succeeded = redisConnection.cache("People", "AdamForClear", person);
        assertEquals(succeeded, true);

        Long clearRes = redisConnection.clear("People", "AdamForClear");
        assertEquals(clearRes ,new Long(1));
    }
}

