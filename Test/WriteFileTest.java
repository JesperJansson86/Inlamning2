import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class WriteFileTest {
    @Test
    public void writeToFileWhenMemberTrainedTest() throws IOException {
       //Kontrollera att filen ändras?
        WriteFile wr1 = new WriteFile();
        wr1.writeToFileWhenMemberTrained("Jesper Jansson");

    }
}
