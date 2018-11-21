package algorithms;

public class StrKmp {

    public int index(String s, String t, int pos) {
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();

        int i = pos;
        int j = 0;
        int[] next = new int[255];
        get_next(tC, next);

        while (i < sC.length && j < tC.length) {
            if (j == 0 || sC[i] == tC[j]) {
                i++; j++;
            } else {
                j = next[j];
            }
        }

        if (j > tC.length) {
            return j - tC.length;
        } else {
            return -1;
        }
    }

    private void get_next(char[] tC, int[] next) {
        int i,j;
        i = 1; j = 0;
        next[0] = 0;
        while (i < tC.length) {
            if (j == 0 || tC[i] == tC[j]) {
                j++; i++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new StrKmp().index("abcabcabc", "ababaaaba", 0));
    }
}
