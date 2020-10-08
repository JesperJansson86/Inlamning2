import org.junit.*;
import java.io.FileNotFoundException;

public class ReadFileTest {
    ReadFile test = new ReadFile();
@Test
    public void readFileReturnStringTest() throws FileNotFoundException {
        Assert.assertEquals(test.readFileReturnString("Testcustomers.txt") ,
                  "7603021234, Alhambra Aromes, 2019-07-01\n"+
                        "8104021234, Bear Belle, 2018-12-02\n");
    }
    @Test
    public void makeListOutOfStringTest() throws FileNotFoundException {
    Assert.assertTrue(test.makeListOutOfString(test.readFileReturnString("customers.txt")).size() ==14);
    }

    @Test
    public void getOnePersonFromTheListTest() throws FileNotFoundException {
    test.personList=test.makeListOutOfString(test.readFileReturnString("customers.txt"));
    Assert.assertEquals(test.getOnePersonFromTheList("8512021234"),"8512021234, Chamade Coriola, 2017-03-12");
    }
}

