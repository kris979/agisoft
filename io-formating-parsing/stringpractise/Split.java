package stringpractise;

import java.util.Arrays;

public class Split {
    public static void main(String[] args) {
        String txt = "x1 23 y #";
        String[] regexes = {"\\d","\\s","\\w"};
        for (String string : regexes) {
            final String[] split = txt.split(string);
            System.out.println(Arrays.toString(split) + ": length = " + split.length);
        }

    }
}
