import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class AdventDay {
    private String[] list = new String[1000];
    private int passes;
    private int decrNum;
    private int incrNum;

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

    private void part2Counter(String[] list){
        decrNum = 0;
        incrNum = 0;

        for (int i = 0; i < list.length - 1; i++) {
            int prev = Integer.parseInt(list[i]);
            int curr = Integer.parseInt(list[i+1]);

            if (prev < curr){
                incrNum ++;
            } else if (prev > curr){
                decrNum ++;
            }
        }
    }

    // 378 -- need a way to remove prev and determine when to instead of curr
    public int part2() {
        passes = 0;
        int i2 = 1;
        for (String line : list) {
            System.out.println();
            System.out.println("(" + i2 + ")  ______");
            i2++;
            boolean incr = false;
            boolean decr = false;
            boolean safe = true;

            String[] lineElements = line.split(" ");

            part2Counter(lineElements);

            if (decrNum > incrNum){
                decr = true;
            } else if (incrNum > decrNum){
                incr = true;
            } else {
                safe = false;
            }

            ArrayList<String> removalList = new ArrayList<String>();
            for (String num : lineElements){
                removalList.add(num);
            }
            removalList.add("0"); // to check the last index too

            // extra case; need condition so that values aren't removed if they are correct but still needs to consider removing the first or later indexes if they're wrong
            for (int i = 0; i < removalList.size() - 1; i++){
                System.out.println(removalList);
                int prev = Integer.parseInt(removalList.get(i));
                System.out.println(prev);
                int curr = Integer.parseInt(removalList.get(i+1));

                if (prev > curr){ // if i is greater than i+1
                    if (incr) {
                        int next = Integer.parseInt(removalList.get(i+1));
                        if (Math.abs(prev - next) < 3) {
                            removalList.remove(i + 1);
                            i--;
                            System.out.println("working");
                        } else if (Math.abs(curr - prev) > 3) {
                            removalList.remove(i);
                            if (i == 1){
                                i = 0;
                            }
                            i--;
                        }
                    }
                } else if (prev < curr){ // if i is less than i+1
                    int next = Integer.parseInt(removalList.get(i+1));
                    if (Math.abs(prev - next) < 3) {
                        removalList.remove(i + 1);
                        i--;
                    } else if (Math.abs(curr - prev) > 3) {
                        removalList.remove(i);
                        if (i == 1){
                            i = 0;
                        }
                        i--;
                    }
                } else {
                    removalList.remove(i+1);
                    i--;
                }

//                if (Math.abs(curr - prev) > 3){
//                    removalList.remove(i+1);
//                    i--;
//                }

                if (removalList.size() < lineElements.length - 1){
                    safe = false;
                }

            }
            if (safe) {
                passes++;
                System.out.println("PASS");
            }
        }
        return passes; //number of lines that pass should be from 613 - 650 or so
    }
}