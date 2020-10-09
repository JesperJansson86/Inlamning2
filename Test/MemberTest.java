import org.junit.Assert;
import org.junit.Test;


public class MemberTest {
    Member test = new Member();

    public MemberTest() {
    }

    @Test
    public void dateDiffTest(){
        test.test=true;
        Assert.assertEquals(test.dateDiff("2020-01-05"),277);
        Assert.assertNotEquals(test.dateDiff("2020-01-05"),0);

    }
    @Test
    public void isMembershipValidTest(){
        Assert.assertTrue(test.isMembershipValid("2020-05-05"));
        Assert.assertFalse(test.isMembershipValid("2019-05-05"));
    }
    @Test
    public void getMemberDateTest() {
        Assert.assertEquals(test.getMemberDate("7603021234, Alhambra Aromes, 2019-07-01\n"),"2019-07-01");
        Assert.assertNotEquals(test.getMemberDate("7603021234, Alhambra Aromes, 2019-07-01\n"),"2020-05-05");
    }
}
