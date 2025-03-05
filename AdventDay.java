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

    public int part2() {
        passes = 0;
        for (String line : list) {
            System.out.println("_____________");
            boolean incr = false;
            boolean decr = false;
            boolean safe = true;

            String[] lineElements = line.split(" ");

            ArrayList<String> removalList = new ArrayList<String>();
            for (String num : lineElements){
                removalList.add(num);
            }

            for (int i = 0; i < removalList.size() - 1; i++){
                int prev = Integer.parseInt(removalList.get(i));
                int curr = Integer.parseInt(removalList.get(i+1));

                if (Math.abs(prev - curr) > 3){
                    removalList.remove(i+1);
                    i--;
                } else if (prev > curr){
                    if (incr) {
                        removalList.remove(i+1);
                        i--;
                    }
                    decr = true;
                } else if (prev < curr){
                    if (decr) {
                        removalList.remove(i+1);
                        i--;
                    }
                    incr = true;
                } else {
                    removalList.remove(i+1);
                    i--;
                }

                System.out.println(removalList);

                if (removalList.size() < lineElements.length - 1){
                    safe = false;
                }

            }
            if (safe) {
                passes++;
            }
        }
        return passes; //number of lines that pass should be from 613 - 650 or so
    }
}