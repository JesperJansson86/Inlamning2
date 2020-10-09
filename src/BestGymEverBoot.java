import javax.swing.*;
import java.io.IOException;
public class BestGymEverBoot {
    public boolean test;
    public String input;

    public void attendance() throws IOException {

        while (true) {
            if (!test) {
                input = JOptionPane.showInputDialog(null, "Namn eller personnummer?");
            }
            if (input == null) break;
            ReadFile rf1 = new ReadFile(input);
            if (rf1.Match) JOptionPane.showMessageDialog(null, "Person finns ej i registret");
            else if (rf1.moreThanOneMatch) JOptionPane.showMessageDialog(null, "Fler än en person hittad:\n"
                    + rf1.matches + "Var god gör en nogrannare sökning");
            else {
                Member m1 = new Member(rf1.matches);
                if (m1.member) {
                    int answer = JOptionPane.showConfirmDialog(null, rf1.matches + "Är en medlem. Medlemskapet löper ut om "
                            + (365 - m1.dateDiff(m1.date)) + " dagar.\nTränar medlemmen idag?", "Medlem funnen!", JOptionPane.YES_NO_OPTION);
                    if (answer == 0) {
                        WriteFile.writeToFileWhenMemberTrained(rf1.matches.substring(0, rf1.matches.length() - 11));
                    }
                } else
                    JOptionPane.showMessageDialog(null, "Medlemskap har gått ut! Det gick ut för " + (m1.dateDiff(m1.date) - 365) + " dagar sedan.");
            }
        }
    }

}
