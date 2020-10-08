import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Member {
    ReadFile rf1 = new ReadFile();
    boolean member =false;
boolean test = false;

    public Member() throws FileNotFoundException {
    }

    public int dateDiff(String date)  {
        LocalDate d1 = LocalDate.parse(date);
        LocalDate d2 = LocalDate.now();
        if(test)d2=LocalDate.parse("2020-10-08");
        return (int) (ChronoUnit.DAYS.between(d1,d2));

    }
    public boolean isMember(String input){
        member = dateDiff(input) < 365;
        return dateDiff(input) < 365;
    }
}
