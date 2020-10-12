import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private String path;
    String stringFromFile;
    String matches;
    Boolean noMatch;
    Boolean moreThanOneMatch;
    List<String> personList = new LinkedList<>();

    public ReadFile(String path, String input) {
        this.path=path;
        readFileReturnString();
        makeListOutOfString();
        getMatchesFromTheList(input);
        isThereMoreThanOneMatch();
        isThereAMatch();
    }


    public void setPath(String path) {
        this.path = path;
    }


    public void readFileReturnString() {
        StringBuilder output = new StringBuilder();
        try (Scanner scan = new Scanner(new File(path))) {
            scan.useDelimiter("\n");
            while (scan.hasNext()) {
                output.append(scan.nextLine());
                output.append(", ");
                output.append(scan.nextLine());
                output.append("\n");
            }
            stringFromFile = output.toString();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Det går ej att hitta filen med personer: " + path);
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void makeListOutOfString() {
        List<String> l = new LinkedList<>();
        Scanner scan = new Scanner(stringFromFile);
        while (scan.hasNext()) l.add(scan.nextLine());
        personList = l;
    }

    public void getMatchesFromTheList(String input) {
        StringBuilder output = new StringBuilder();
        String temp;
        for (String s : personList) {
            temp = s;
            if (temp.toLowerCase().contains(input.toLowerCase())) {
                output.append(temp);
                output.append("\n");
            }
        }
        matches= output.toString();
    }

    public void isThereAMatch() {
        noMatch = matches.equals("");
    }

    public void isThereMoreThanOneMatch() {

        moreThanOneMatch= (matches.lastIndexOf("\n")) != (matches.indexOf("\n"));
    }
}
