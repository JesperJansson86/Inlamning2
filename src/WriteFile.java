import java.io.*;
import java.time.LocalDate;

public class WriteFile {

    public static void writeToFileWhenMemberTrained(String input) {
       try(BufferedWriter w = new BufferedWriter(new PrintWriter(new FileWriter(new File("MembersTrained.txt"),true)))){
        w.write(input+" "+ LocalDate.now()+"\n");
    }catch (IOException e){
           System.out.println("Det går ej att skriva till filen.");
           e.printStackTrace();
       }
}
}
