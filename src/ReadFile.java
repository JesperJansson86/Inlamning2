import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private String path = "customers.txt";
    String stringFromFile;
    List personList = new LinkedList();
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }




    public void readFileReturnString() throws FileNotFoundException {
        StringBuilder output = new StringBuilder();
        Scanner scan = new Scanner(new File(path));
        scan.useDelimiter("\n");
        while (scan.hasNext()) {
            output.append(scan.nextLine() + ", ");
            output.append(scan.nextLine() + "\n");
        }
        stringFromFile=output.toString();
    }

    public void makeListOutOfString() {
        List<String> l = new LinkedList();
        Scanner scan = new Scanner(stringFromFile);
        while (scan.hasNext()) l.add(scan.nextLine());
        personList=l;
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
