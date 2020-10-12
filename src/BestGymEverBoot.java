import javax.swing.*;

public class BestGymEverBoot {
    public boolean test;
    public String input;
    public String output;
    public boolean loop = true;

    public void attendance() {

        while (loop) {
            if (!test) {
                input = JOptionPane.showInputDialog(null, "Namn eller personnummer?");
            }
            if (input == null) break;
            ReadFile rf1 = new ReadFile("customers.txt", input);
            if (rf1.noMatch)
                output = thereIsNoSuchPerson();
            else if (rf1.moreThanOneMatch) {
                thereIsMoreThanOnePerson(rf1);
            } else {
                Member m1 = new Member(rf1.matches);
                if (m1.isMember) {
                    thisPersonIsAMember(rf1, m1);
                } else {
                    thisPersonsMembershipHasExpired(rf1, m1);

                }
            }
        }

    }

    public String thereIsNoSuchPerson() {
        if (test) loop = false;
        if (!test) JOptionPane.showMessageDialog(null, "Person finns ej i registret");
        return "Person finns ej i registret";
    }

    public String thereIsMoreThanOnePerson(ReadFile rf) {
        if (test) loop = false;
        if (!test) JOptionPane.showMessageDialog(null, "Fler än en person hittad:\n"
                + rf.matches + "Var god gör en nogrannare sökning");
        return "Fler än en person hittad";
    }

    public String thisPersonIsAMember(ReadFile rf1, Member m1) {
        if (test) loop = false;
        if (!test) {
            int answer = JOptionPane.showConfirmDialog(null, rf1.matches + "Är en medlem. Medlemskapet löper ut om "
                    + (365 - m1.dateDiff(m1.date)) + " dagar.\nTränar medlemmen idag?", "Medlem funnen!", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                WriteFile.writeToFileWhenMemberTrained(rf1.matches.substring(0, rf1.matches.length() - 11));
            }
        }
        return "Är en medlem.";
    }

    public String thisPersonsMembershipHasExpired(ReadFile rf1, Member m1) {
        if (!test)
            JOptionPane.showMessageDialog(null, rf1.matches + "\nMedlemskap har gått ut! Det gick ut för " + (m1.dateDiff(m1.date) - 365) + " dagar sedan.");
        return "Medlemskap har gått ut!";

    }

}

