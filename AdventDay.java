import java.util.Arrays;

public class AdventDay{
    private String[] list = new String[1000];
    private boolean incr;
    private boolean decr;
    private boolean safe;
    private int passes;
    private int counter;

    public AdventDay(String[] array){
        list = array;
        safe = true;
        incr = false;
        decr = false;
        counter = 0;
    }

    public int sorter(){
        for (String line : list) {
            incr = false;
            decr = false;
            safe = true;
            int space = 0;
            while ((line.contains(" ")) && safe) {
                space = line.indexOf(" ");
                String prev = line.substring(0, space);
                line = line.substring(space+1);
                space = line.indexOf(" ");
                if (space == -1){
                    space = 1;
                }
                String curr = line.substring(0, space);

                if ((Math.abs(Integer.parseInt(prev) - Integer.parseInt(curr)) > 3)){
                    safe = false;
                }

                if (Integer.parseInt(prev) > Integer.parseInt(curr)){    // if greater than
                    if (incr){
                        safe = false;
                    }
                    decr = true;
                } else if (Integer.parseInt(prev) < Integer.parseInt(curr)) {   // if less than
                    if (decr){
                        safe = false;
                    }
                    incr = true;
                } else {  // if prev and curr are the same value
                    safe = false;
                }
            }
            if (safe){
                passes ++;
            }

            counter++;
        }
        return passes; //number of lines that pass
    }
}
