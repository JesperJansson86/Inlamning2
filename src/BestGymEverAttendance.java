import javax.swing.*;
import java.io.FileNotFoundException;


public class BestGymEverAttendance {
    public static void attendance() throws FileNotFoundException {

        while (true) {
           String input = JOptionPane.showInputDialog(null, "Namn eller personnummer?");
           if (input==null)break;
            ReadFile rf1 = new ReadFile();

             rf1.readFileReturnString();
             rf1.makeListOutOfString();
            input= rf1.getMatchesFromTheList(input);
            try {
                String date = input.substring(input.length() - 11, input.length() - 1);
                Member m1 = new Member();
                m1.isMember(date);
                if (m1.member) {
                    JOptionPane.showMessageDialog(null, input + "Är en medlem");
                } else JOptionPane.showMessageDialog(null, "Medlemskap har gått ut!");
            }catch (IndexOutOfBoundsException e){JOptionPane.showMessageDialog(null,"Person finns ej i registret");}
        }
    }
}
