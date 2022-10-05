import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicListTest {

    private static DynamicList dynamicList;

    @BeforeEach
    void setUp() {
        dynamicList = new DynamicList();
        dynamicList.insert(1);
        dynamicList.insert(2);
        dynamicList.insert(3);
    }

    @Test
    void size() {
        Assert.assertEquals(3, dynamicList.size());
    }

    @Test
    void insert() {
        dynamicList.insert(4);
        Assert.assertEquals(4, dynamicList.size());
    }

    @Test
    void get() {
        Assert.assertEquals(3, dynamicList.get(2));
    }

    @Test
    void remove() {
        dynamicList.remove(2);
        Assert.assertEquals(2, dynamicList.size());
    }

    @Test
    void testToString() {
        Assert.assertEquals("1,2,3", dynamicList.toString());
    }
}