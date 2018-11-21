package algorithms;

public class StrCmp {

    public int index(String s, String t, int pos) {
        int i = pos;
        int j = 0;
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        while (i < s.length() && j < t.length()) {
            if (sC[i] == tC[j]) {
                i++;
                j++;
            } else {
                i = i -j + 1;
                j = 0;
            }
        }

        if (j == t.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        StrCmp strCmp = new StrCmp();
        System.out.println(strCmp.index("asb", "ab", 0));
    }
}
