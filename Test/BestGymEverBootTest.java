import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;

public class BestGymEverBootTest {
    BestGymEverBoot boot = new BestGymEverBoot();

    public void attendanceTest() throws IOException {
        boot.test=true;
        boot.input="ase213sae";
       // Assert.assertNotEquals(boot.attendance(), "ase213sae");
    }
}
