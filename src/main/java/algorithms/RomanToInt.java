/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.RomanToInt
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * RomanToInt
 * @description TODO
 * @author liubolun
 * @date 2019年11月13日 21:45
 * @version 2.9
 */
public class RomanToInt {

    public int romanToInt(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'I') {
                count += 1;
            } else if (c == 'V') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                    count += 4;
                    i--;
                } else {
                    count += 5;
                }
            } else if (c == 'X') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                    count += 9;
                    i--;
                } else {
                    count += 10;
                }
            } else if (c == 'L') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                    count += 40;
                    i--;
                } else {
                    count += 50;
                }
            } else if (c == 'C') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                    count += 90;
                    i--;
                } else {
                    count += 100;
                }
            } else if (c == 'D') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                    count += 400;
                    i--;
                } else {
                    count += 500;
                }
            } else if (c == 'M') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                    count += 900;
                    i--;
                } else {
                    count += 100;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        romanToInt.romanToInt("MCMXCIV");
    }
}
