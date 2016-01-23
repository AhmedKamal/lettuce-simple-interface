package redis.SimpleSerializers;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import redis.Person;

import java.util.ArrayList;

import static redis.Person.assertEqualsForPerson;
/**
 * @author <a href="mailto:a.abdelfatah@live.com">Ahmed Kamal</a>
 * @since 23.01.16 09:17
 */
public class JavaSerializerTest{

    JavaSerializer serializer;
    @Before
    public void setUp() throws Exception {
        serializer = new JavaSerializer();
    }

    @Test
    public void testSerializeObject() {

        byte[] serializedSteve = serializer.serializeObject(Person.createPersonSteve());
        Assert.assertNotNull(serializedSteve);
    }

    @Test
    public void testDeserializeObject() {
        byte[] serializedSteve = serializer.serializeObject(Person.createPersonSteve());
        Person steve = serializer.deserializeObject(serializedSteve);

        assertEqualsForPerson(steve, Person.createPersonSteve());
    }

    @Test
    public void testSerializeObjectList(){
        byte[] serializedList = serializer.serializeObject(Person.getPersonList());
        Assert.assertNotNull(serializedList);
    }

    @Test
    public void testDeserializeObjectList(){
        byte[] serializedList = serializer.serializeObject(Person.getPersonList());
        ArrayList<Person> objectList = serializer.deserializeObject(serializedList);

        assertEqualsForPerson(objectList.get(0), Person.createPersonAdam());
        assertEqualsForPerson(objectList.get(1), Person.createPersonSara());
        assertEqualsForPerson(objectList.get(2), Person.createPersonSteve());
    }
}