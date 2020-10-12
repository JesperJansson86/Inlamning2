import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Member {
    boolean member = false;
    boolean test = false;
    String date;

    public Member() {

    }

    public Member(String input) {
        date = getMemberDate(input);
        isMembershipValid(date);

    }


    public int dateDiff(String date) {
        LocalDate d1 = LocalDate.parse(date);
        LocalDate d2 = LocalDate.now();
        if (test) d2 = LocalDate.parse("2020-10-08");
        return (int) (ChronoUnit.DAYS.between(d1, d2));

    }

    public boolean isMembershipValid(String input) {
        member = dateDiff(input) < 365;
        return dateDiff(input) < 365;
    }

    public String getMemberDate(String input) {

        return input.substring(input.length() - 11, input.length() - 1);
    }
}
