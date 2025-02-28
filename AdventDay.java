public class AdventDay {
    private String[] list = new String[1000];
    private boolean incr;
    private boolean decr;
    private boolean safe;
    private int passes;

    public AdventDay(String[] array) {
        list = array;
        safe = true;
        incr = false;
        decr = false;
    }

    public int part1() {
        for (String line : list) {
            incr = false;
            decr = false;
            safe = true;

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
        for (String line : list) {
            incr = false;
            decr = false;
            safe = true;
            int counter = 0;

            boolean badLevel = false;

            String[] lineElements = line.split(" ");

            for (int i = 0; i < lineElements.length - 1; i++){
                int prev = Integer.parseInt(lineElements[i]);
                int curr = Integer.parseInt(lineElements[i+1]);

                if (Math.abs(prev - curr) > 3){
                    safe = false;
                    badLevel = true;
                }

                if (prev > curr){
                    if (incr) {
                        safe = false;
                        badLevel = true;
                    }
                    decr = true;
                } else if (prev < curr){
                    if (decr) {
                        safe = false;
                        badLevel = true;
                    }
                    incr = true;
                } else {
                    safe = false;
                    badLevel = true;
                }

                if (badLevel){
                    counter ++;
                }

            }
            if (safe && (counter <= 1)) {
                passes++;
            }
        }
        return passes; //number of lines that pass should be from 585 - 650 or so
    }
}