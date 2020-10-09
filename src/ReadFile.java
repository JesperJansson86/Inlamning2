import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private String path = "customers.txt";
    String stringFromFile;
    String matches;
    Boolean Match;
    Boolean moreThanOneMatch;
    List<String> personList = new LinkedList<>();

//    public ReadFile() throws FileNotFoundException {
//        readFileReturnString();
//        makeListOutOfString();
//
//    }

    public ReadFile(String input) throws FileNotFoundException {
        readFileReturnString();
        makeListOutOfString();
        matches = getMatchesFromTheList(input);
        moreThanOneMatch = isThereMoreThanOneMatch(matches);
        Match = isThereAMatch();
    }

//    public String getPath() {
//        return path;
//    }

    public void setPath(String path) {
        this.path = path;
    }


    public void readFileReturnString() {
        StringBuilder output = new StringBuilder();
       try{
        Scanner scan = new Scanner(new File(path));
        scan.useDelimiter("\n");
        while (scan.hasNext()) {
            output.append(scan.nextLine());
            output.append(", ");
            output.append(scan.nextLine());
            output.append("\n");
        }
        stringFromFile = output.toString();
    }catch (FileNotFoundException e){
           JOptionPane.showMessageDialog(null,"Det går ej att hitta filen med personer: " +path);
           System.exit(-1);
       }
    }

    public void makeListOutOfString() {
        List<String> l = new LinkedList<>();
        Scanner scan = new Scanner(stringFromFile);
        while (scan.hasNext()) l.add(scan.nextLine());
        personList = l;
    }

    public String getMatchesFromTheList(String input) {
        StringBuilder output = new StringBuilder();
        String temp;
        for (String s : personList) {
            temp = s;
            if (temp.toLowerCase().contains(input.toLowerCase())) {
                output.append(temp);
                output.append("\n");
            }
        }
        return output.toString();
    }

    public boolean isThereAMatch() {
        return matches.equals("");
    }

    public boolean isThereMoreThanOneMatch(String input) {

        return (input.lastIndexOf("\n")) != (input.indexOf("\n"));
    }
}
