import javax.swing.*;
import java.io.FileNotFoundException;


public class BestGymEverAttendance {
    public static void attendance() throws FileNotFoundException {
        String input ="start";
        while (input != null) {
            input = JOptionPane.showInputDialog(null, "Namn eller personnummer?");
            ReadFile rf1 = new ReadFile();

            rf1.readFileReturnString();
            rf1.makeListOutOfString();
            input= rf1.getMatchesFromTheList(input);
            String date = input.substring(input.length()-11, input.length()-1);
            Member m1 = new Member();
            m1.isMember(date);
            if (m1.member){JOptionPane.showMessageDialog(null,input+"Är en medlem");
            }else JOptionPane.showMessageDialog(null, "Medlemskap har gått ut!");

        }
    }
}
