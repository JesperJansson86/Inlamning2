import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private String path = "customers.txt";
    String stringFromFile;
    String matches;
    Boolean Match =false;
    Boolean morethanOneMatch = false;
    List personList = new LinkedList();

    public ReadFile() throws FileNotFoundException {
        readFileReturnString();
        makeListOutOfString();
    }

    public ReadFile(String input) throws FileNotFoundException {
        readFileReturnString();
        makeListOutOfString();
        matches=getMatchesFromTheList(input);
        morethanOneMatch= isThereMoreThanOneMatch(matches);
        Match=isThereAMatch();
    }

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
        stringFromFile = output.toString();
    }

    public void makeListOutOfString() {
        List<String> l = new LinkedList();
        Scanner scan = new Scanner(stringFromFile);
        while (scan.hasNext()) l.add(scan.nextLine());
        personList = l;
    }

    public String getMatchesFromTheList(String input) {
        String output = "";
        String temp;
        int counter = 0;
        for (int i = 0; i < personList.size(); i++) {
            temp = (String) personList.get(i);
            if (temp.toLowerCase().contains(input.toLowerCase())) {
                output += temp + "\n";
            }
        }
        return output;
    }
    public boolean isThereAMatch(){
        return  matches =="";
    }

    public boolean isThereMoreThanOneMatch(String input) {
        return (input.lastIndexOf("\n")) != (input.indexOf("\n"));
    }
}
