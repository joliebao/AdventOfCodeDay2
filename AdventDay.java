import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class AdventDay {
    private String[] list = new String[1000];
    private int passes;

    public AdventDay(String[] array) {
        list = array;
    }

    public int part1() {
        for (String line : list) {
            boolean incr = false;
            boolean decr = false;
            boolean safe = true;

            String[] lineElements = line.split(" ");

            for (int i = 0; i < lineElements.length - 1; i++){
                int prev = Integer.parseInt(lineElements[i]);
                int curr = Integer.parseInt(lineElements[i+1]);

                if (Math.abs(prev - curr) > 3){
                    safe = false;
                }

                if (prev > curr){
                    if (incr) {
                        safe = false;
                    }
                    decr = true;
                } else if (prev < curr){
                    if (decr) {
                        safe = false;
                    }
                    incr = true;
                } else {
                    safe = false;
                }
            }

            if (safe) {
                passes++;
            }
        }
        return passes; //number of lines that pass
    }

    private ArrayList<Integer> getDifferences(String[] arr){
        ArrayList<Integer> differences = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i ++){
            int prev = Integer.parseInt(arr[i]);
            int curr = Integer.parseInt(arr[i+1]);

            differences.add(prev-curr);
        }
        return differences;
    }

    private boolean bounds(int count, String[] arr){
        int prev = Integer.parseInt(arr[count]);
        int next = Integer.parseInt(arr[count + 2]);
        if (Math.abs(prev - next) > 3) {
            return true;
        }
        return false;
    }

    // 378 -- need a way to remove prev and determine when to instead of curr
    public int part2() {
        passes = 0;
        int i2 = 1;
        for (String line : list) {
            int badLevels = 0;

            System.out.println();
            System.out.println("(" + i2 + ")  ______");
            i2++;

            String[] lineElements = line.split(" ");
            ArrayList<Integer> lineDiff = getDifferences(lineElements);

            System.out.println(lineDiff);


            int counter = 0;

            for (int i = 0; i < lineDiff.size() - 1; i++){
                if (Math.abs(lineDiff.get(i)) > 3){
                    badLevels ++;
                    if (bounds(counter, lineElements)) {
                        badLevels++;
                    }
                } else if (lineDiff.get(i) == 0){
                    badLevels ++;
                } else if (lineDiff.get(i) > 0 && lineDiff.get(i+1) < 0){
                    badLevels ++;
                } else if (lineDiff.get(i) < 0 && lineDiff.get(i+1) > 0) {
                    badLevels++;
                }

                counter ++;
            }

            if (Math.abs(lineDiff.getLast()) > 3){
                badLevels ++;
            } else if (lineDiff.getLast() == 0){
                badLevels ++;
            }

            if (badLevels <= 1) {
                passes++;
                System.out.println("PASS");
            }
        }
        return passes; //number of lines that pass should be from 613 - 650 or so
    }
}