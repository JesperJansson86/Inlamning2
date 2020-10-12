import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Member {
    boolean test = false;
    boolean isMember = false;
    String date;

    public Member() {

    }
    //7603021234, Alhambra Aromes, 2019-07-01\n
    public Member(String input) {
        date = getMemberDate(input);
        isMembershipValid(date);

    }
    public String getMemberDate(String input) {

        return input.substring(input.length() - 11, input.length() - 1);
    }

    public boolean isMembershipValid(String input) {
        isMember = dateDiff(input) < 365;
        return dateDiff(input) < 365;
    }

    public int dateDiff(String date) {
        LocalDate d1 = LocalDate.parse(date);
        LocalDate d2 = LocalDate.now();
        if (test) d2 = LocalDate.parse("2020-10-08");
        return (int) (ChronoUnit.DAYS.between(d1, d2));

    }




}
