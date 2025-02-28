public class AdventDay {
    private String[] list = new String[1000];
    private boolean incr;
    private boolean decr;
    private boolean safe;
    private int passes;
    private int counter;

    public AdventDay(String[] array) {
        list = array;
        safe = true;
        incr = false;
        decr = false;
        counter = 0;
    }

    public int sorter() {
        for (String line : list) {
            incr = false;
            decr = false;
            safe = true;
            int space = 0;

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

                counter++;
            }
        return passes; //number of lines that pass
    }
}