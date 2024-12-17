import java.util.ArrayList;
import java.util.List;

public class AdventDay{
    private List <String> list = new ArrayList<String>();
    private boolean safe;

    public AdventDay(ArrayList<String> l){
        list = l;
        safe = true;
    }

    public int sorter(){
        int prev = 0;
        int current = 0;
        for (int i = 0; i < list.size(); i++){
            String line = list.get(i); // one line of code
            line = line.replace(" ", "");
            prev = Integer.parseInt(line.substring(i-1,i));
            current = Integer.parseInt(line.substring(i,i+1));
            if (current < prev) {
                for (int i2 = 0; i2 < line.length(); i2++) {
                    prev = Integer.parseInt(line.substring(i-1,i));
                    current = Integer.parseInt(line.substring(i,i+1));
                }
                prev = current;
            }

                // TO DO __--__---__--_-_---_____
                // separate each number in the string line and turn them into ints
                // prev is set to the last number
                // prev will be 1 less than the length of the line
                // set current to the second number of the line
                // current will be the length of the line

                // test if the prev is less than current
                // iterate to next, and set prev to current and increase current by 1
                // if prev = current, or current < prev, boolean is false
                // test else if the prev is more than the current
                // iterate to next, and set prev to current and increase current by 1
                // if prev = current, or current > prev, boolean is false

                // test for all lines in the list
                // if lines are true, increase counter by 1
                // return counter
            }
        }
        return 0; // placeholder --- change later
    }
}
