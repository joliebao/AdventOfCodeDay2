import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdventSolver {
    public static void main(String[] args) {

        String[] fileData = getFileData("src/InputFile");
        // you now have a list of Strings from the file "InputFile"

        System.out.println(Arrays.toString(fileData));
//        AdventDay a = new AdventDay(fileData);
//        System.out.println(a.sorter());
    }

    public static String[] getFileData(String fileName) {
        String[] fileData = new String[1000];
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            int i = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    fileData[i] = line;
                }
                i++;
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}