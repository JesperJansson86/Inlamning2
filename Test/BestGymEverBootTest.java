import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BestGymEverBootTest {
    BestGymEverBoot boot = new BestGymEverBoot();
    ReadFile rf = new ReadFile("hej");
    Member m1 = new Member();


    public BestGymEverBootTest() {

    }

    @Test
    public void thereIsNoSuchPersonTest() {
        boot.test = true;
        boot.input = "ase213sae";
        Assert.assertEquals(boot.thereIsNoSuchPerson(), "Person finns ej i registret");
        Assert.assertNotEquals(boot.thereIsNoSuchPerson(), "");
    }

    @Test
    public void thereIsMoreThanOnePersonTest()  {
        boot.test = true;
        boot.input = "123";
        Assert.assertEquals(boot.thereIsMoreThanOnePerson(rf), "Fler än en person hittad");
        Assert.assertNotEquals(boot.thereIsMoreThanOnePerson(rf), "");
    }

    @Test
    public void thisPersonIsAMemberTest()  {
        boot.test = true;
        boot.input = "Greger";
        Assert.assertEquals(boot.thisPersonIsAMember(rf, m1), "Är en medlem.");
        Assert.assertNotEquals(boot.thisPersonIsAMember(rf, m1), "");
    }
    @Test
    public void thisPersonsMembershipHasExpiredTest(){
        boot.test = true;
        boot.input = "Bear";
        Assert.assertEquals(boot.thisPersonsMembershipHasExpired(m1), "Medlemskap har gått ut!");
        Assert.assertNotEquals(boot.thisPersonsMembershipHasExpired(m1), "");
    }
}
