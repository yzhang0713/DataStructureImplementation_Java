import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    private static LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
    }

    @Test
    void size() {
        Assertions.assertEquals(3, linkedList.size());
    }

    @Test
    void insert() {
        linkedList.insert(4);
        Assertions.assertEquals(4, linkedList.size());
    }

    @Test
    void get() {
        Assertions.assertEquals(3, linkedList.get(2));
    }

    @Test
    void remove() {
        linkedList.remove(2);
        Assertions.assertEquals(2, linkedList.size());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("1,2,3", linkedList.toString());
    }
}