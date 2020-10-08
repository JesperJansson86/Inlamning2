import java.io.*;
import java.time.LocalDate;

public class WriteFile {

    public void writeToFileWhenMemberTrained(String input) throws IOException {
        BufferedWriter w = new BufferedWriter(new PrintWriter(new FileWriter(new File("MembersTrained.txt"),true)));
        w.write(input+" "+ LocalDate.now()+"\n");
        w.close();
    }
}
