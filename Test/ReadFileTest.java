import org.junit.*;

public class ReadFileTest {
    ReadFile test = new ReadFile("customersTest.txt","Spelar ej roll vid testning");


    @Test
    public void readFileReturnStringTest() {
        test.setPath("Testcustomersshort.txt");
        test.readFileReturnString();
        Assert.assertEquals(test.stringFromFile,
                "7603021234, Alhambra Aromes, 2019-07-01\n8104021234, Bear Belle, 2018-12-02\n");
    }

    @Test
    public void makeListOutOfStringTest()  {
        Assert.assertTrue(test.personList.size() == 14);
        Assert.assertFalse(test.personList.size() == 0);
    }

    @Test
    public void getMatchesFromTheListTest()  {
        test.getMatchesFromTheList("asdasd123123asd");
        Assert.assertEquals(test.matches, "");
        test.getMatchesFromTheList("8512021234");
        Assert.assertEquals(test.matches, "8512021234, Chamade Coriola, 2017-03-12\n");
        test.getMatchesFromTheList("Greger");
        Assert.assertEquals(test.matches, "7512166544, Greger Ganache, 2020-03-23\n");
        test.getMatchesFromTheList("212");
        Assert.assertEquals(test.matches,
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
        test.isThereAMatch();
        Assert.assertTrue(test.noMatch);
        test.matches = "8512021234, Chamade Coriola, 2017-03-12\n";
        test.isThereAMatch();
        Assert.assertFalse(test.noMatch);

    }

    @Test
    public void isThereMoreThanOneMatchTest() {
        test.matches="8512021234, Chamade Coriola, 2017-03-12\n";
        test.isThereMoreThanOneMatch();
        Assert.assertFalse(test.moreThanOneMatch);
        test.matches="";
        test.isThereMoreThanOneMatch();
        Assert.assertFalse(test.moreThanOneMatch);
        test.matches="8512021234, Chamade Coriola, 2017-03-12\n8104021234, Bear Belle, 2018-12-02\n";
        test.isThereMoreThanOneMatch();
        Assert.assertTrue(test.moreThanOneMatch);

    }


}

