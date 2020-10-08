import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;


public class MemberTest {
    Member test = new Member();

    public MemberTest() throws FileNotFoundException {
    }

    @Test
    public void dateDiffTest(){
        test.test=true;
        Assert.assertTrue(test.dateDiff("2020-01-05")==277);
        Assert.assertFalse(test.dateDiff("2020-01-05")==0);

    }
    @Test
    public void isMemberTest(){
        Assert.assertTrue(test.isMember("2020-05-05"));
        Assert.assertFalse(test.isMember("2019-05-05"));
    }
}
