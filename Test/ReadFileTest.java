import org.junit.*;

import java.io.FileNotFoundException;

public class ReadFileTest {
    ReadFile test = new ReadFile("customers.txt");


    @Test
    public void readFileReturnStringTest() throws FileNotFoundException {
        test.setPath("Testcustomers.txt");
        test.readFileReturnString();
        Assert.assertEquals(test.stringFromFile,
                "7603021234, Alhambra Aromes, 2019-07-01\n8104021234, Bear Belle, 2018-12-02\n");
    }

    @Test
    public void makeListOutOfStringTest() throws FileNotFoundException {
        Assert.assertTrue(test.personList.size() == 14);
        Assert.assertFalse(test.personList.size() == 0);
    }

    @Test
    public void getMatchesFromTheListTest() throws FileNotFoundException {
        Assert.assertEquals(test.getMatchesFromTheList("sdfsdfdsf"), "");
        Assert.assertEquals(test.getMatchesFromTheList("8512021234"), "8512021234, Chamade Coriola, 2017-03-12\n");
        Assert.assertEquals(test.getMatchesFromTheList("Greger"), "7512166544, Greger Ganache, 2020-03-23\n");
        Assert.assertEquals(test.getMatchesFromTheList("212"),
                "7603021234, Alhambra Aromes, 2019-07-01\n" +
                        "8104021234, Bear Belle, 2018-12-02\n" +
                        "8512021234, Chamade Coriola, 2017-03-12\n" +
                        "7608021234, Diamanda Djedi, 2020-01-30\n" +
                        "7605021234, Elmer Ekorrsson, 2010-04-07\n" +
                        "5711121234, Hilmer Heur, 2019-08-18\n");

    }

    @Test
    public void isThereAMatchTest() {
        test.matches = "";
        Assert.assertTrue(test.isThereAMatch());
        test.matches = "8512021234, Chamade Coriola, 2017-03-12\n";
        Assert.assertFalse(test.isThereAMatch());

    }

    @Test
    public void isThereMoreThanOneMatchTest() {
        Assert.assertFalse(test.isThereMoreThanOneMatch("8512021234, Chamade Coriola, 2017-03-12\n"));
        Assert.assertFalse(test.isThereMoreThanOneMatch(""));
        Assert.assertTrue(test.isThereMoreThanOneMatch(
                "8512021234, Chamade Coriola, 2017-03-12\n8104021234, Bear Belle, 2018-12-02\n"));

    }

    public ReadFileTest() throws FileNotFoundException {
    }
}

