import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdventSolver {
    public static void main(String[] args) {
        String[] fileData = getFileData("InputFile");
        // you now have a list of Strings from the file "InputFile"

        System.out.println(Arrays.toString(fileData));
        AdventDay a = new AdventDay(fileData);
        System.out.println(a.sorter());
    }

    public static String[] getFileData(String fileName) {
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            String lines = "";
            while (s.hasNextLine()) {
                lines += s.nextLine() + " , ";
            }
            return lines.split(" , ");
        } catch (FileNotFoundException e) {
            String[] fileData = {"Not working..."};
            return fileData;
        }
    }
}