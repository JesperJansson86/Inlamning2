import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    String path = "customers.txt";
    List personList = new LinkedList();

    public String readFileReturnString(String path) throws FileNotFoundException {
        StringBuilder output = new StringBuilder();
        Scanner scan = new Scanner(new File(path));
        scan.useDelimiter("\n");
        while (scan.hasNext()) {
            output.append(scan.nextLine() + ", ");
            output.append(scan.nextLine() + "\n");
        }
        return output.toString();
    }

    public List makeListOutOfString(String input) {
        List<String> l = new LinkedList();
        Scanner scan = new Scanner(input);
        while (scan.hasNext()) l.add(scan.nextLine());
        return l;
    }
    public String getMatchesFromTheList(String input){
        String output ="";
        String temp;
        int counter = 0;
        for (int i = 0; i < personList.size(); i++) {
            temp = (String )personList.get(i);
            if (temp.contains(input)){
                output += temp+"\n";
            }
        }
        return output;
    }
}
