/**
 * Created by claytonlewis on 4/25/17.
 */
public class Suffix implements Comparable{
    //static variables
    private static String text;
    private static int N;

    //instance variables
    private int index;

    public static void setText(String input) {
        N = input.length();
        text = input.concat(input);
    }

    public Suffix(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int i) {
        index = i;
    }

    @Override
    public int compareTo(Object o) {
        Suffix other = (Suffix) o;
        /*
        String s = text.substring(index, index + N);
        String t = o.toString();
        return s.compareTo(t);
        */
        for (int k = 0; k < N; k++) {
            if (text.charAt(index + k) > other.charAt(k)) {
                return 1;
            } else if (text.charAt(index + k) < other.charAt(k)) {
                return -1;
            }
        }
        return 0;
    }

    public char charAt(int i) {
        return text.charAt(index + i);
    }

    public char lastChar() {
        return text.charAt(index + N - 1);
    }

    public String toString() {
        String s = text.substring(index, index + N);
        return s;
    }
}
