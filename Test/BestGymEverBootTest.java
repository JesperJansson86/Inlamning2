import org.junit.Assert;
import org.junit.Test;

public class BestGymEverBootTest {
    BestGymEverBoot boot = new BestGymEverBoot();
    ReadFile rf = new ReadFile("customersTest.txt", "Input ändras för varje eget test.");
    Member m1 = new Member();


    @Test
    public void thereIsNoSuchPersonTest() {
        boot.test = true;
        boot.input = "ase213sae";
        Assert.assertEquals(boot.thereIsNoSuchPerson(), "Person finns ej i registret");
        Assert.assertNotEquals(boot.thereIsNoSuchPerson(), "");
    }

    @Test
    public void thereIsMoreThanOnePersonTest() {
        boot.test = true;
        boot.input = "123";
        Assert.assertEquals(boot.thereIsMoreThanOnePerson(rf), "Fler än en person hittad");
        Assert.assertNotEquals(boot.thereIsMoreThanOnePerson(rf), "");
    }

    @Test
    public void thisPersonIsAMemberTest() {
        boot.test = true;
        boot.input = "Greger";
        m1.test = true;
        Assert.assertEquals(boot.thisPersonIsAMember(rf, m1), "Är en medlem.");
        Assert.assertNotEquals(boot.thisPersonIsAMember(rf, m1), "");
    }

    @Test
    public void thisPersonsMembershipHasExpiredTest() {
        boot.test = true;
        m1.test = true;
        boot.input = "Bear";
        Assert.assertEquals(boot.thisPersonsMembershipHasExpired(rf, m1), "Medlemskap har gått ut!");
        Assert.assertNotEquals(boot.thisPersonsMembershipHasExpired(rf, m1), "");
    }
}
