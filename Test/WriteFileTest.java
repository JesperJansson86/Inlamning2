import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class WriteFileTest {
    @Test
    public void writeToFileWhenMemberTrainedTest() throws IOException {
        Path file = Paths.get("MembersTrained.txt");
        BasicFileAttributes beforeFileAtt = Files.readAttributes(file, BasicFileAttributes.class);
        WriteFile wr1 = new WriteFile();
        wr1.writeToFileWhenMemberTrained("Test");
        BasicFileAttributes afterFileAtt = Files.readAttributes(file, BasicFileAttributes.class);
        Assert.assertTrue(beforeFileAtt!=afterFileAtt);
        Assert.assertFalse(beforeFileAtt==afterFileAtt);


    }
}
