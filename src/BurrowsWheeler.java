import java.util.Arrays;

public class BurrowsWheeler {
    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    public static void encode()
    {
        String input = StdIn.readAll();
        int N = input.length();
        int start = 0;
        String encoded = "";
        Suffix.setText(input);
        Suffix[] suffixes = new Suffix[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = new Suffix(i);
        }

        /*for (int i = 0; i < N; i++) {
            suffixes[i] = input.substring(i, N).concat(input.substring(0, i));
            //suffixes[i] = "" + input.charAt(i) + input.charAt(i - 1);
        }
        Arrays.sort(suffixes);

        for (int i = 0; i < N; i++) {
            encoded.concat(String.valueOf(suffixes[i].charAt(N - 1)));
            if (suffixes[i].equals(input)) {
                start = i;
            }
        } */

        /*
        int R = 256;
        Suffix[] aux = new Suffix[N];

        for (int d = N-1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++)
                count[suffixes[i].charAt(d) + 1]++;

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // move data
            for (int i = 0; i < N; i++)
                aux[count[suffixes[i].charAt(d)]++] = suffixes[i];

            // copy back
            for (int i = 0; i < N; i++)
                suffixes[i] = aux[i];
        }
        */

        Merge.sort(suffixes);

        for (int i = 0; i < N; i++) {
            //StdOut.println(suffixes[i].toString());
            if (suffixes[i].getIndex() == 0)
                start = i;
            encoded += suffixes[i].lastChar();
        }

        BinaryStdOut.write(start);
        BinaryStdOut.write(encoded);
        BinaryStdOut.flush();
        //StdOut.println(encoded);
    }

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode()
    {
        int start = BinaryStdIn.readInt();
        String input = BinaryStdIn.readString();
        while (!BinaryStdIn.isEmpty()) {
            input += BinaryStdIn.readString();
        }
        //StdOut.println(input);
        int N = input.length();
        int[] next = new int[N];
        Boolean[] marked = new Boolean[N];
        Character[] first = new Character[N];
        for (int i = 0; i < N; i++) {
            first[i] = input.charAt(i);
            marked[i] = false;
        }
        Arrays.sort(first);
        int i = 0;
        while (i < N) {
            int j = 0;
                while (j < N) {
                    if ((input.charAt(j) == first[i]) && (marked[j] == false)) {
                        next[i++] = j;
                        marked[j++] = true;
                        break;
                    }
                    j++;
                }
        }
        /*for (int j = 0; j < N; j++) {
            StdOut.printf("%c ? %c %d\n", first[j], input.charAt(j), next[j]);
        }
        */
        i = start;
        for (int count = 0; count < N; count++) {
            i = next[i];
            StdOut.print(input.charAt(i));
        }
    }

    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args)
    {
        if (args[0].equals("-"))
            encode();
        else if (args[0].equals("+"))
            decode();
    }
}