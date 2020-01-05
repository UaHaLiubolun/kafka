/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.IntegerBreak
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * IntegerBreak
 * @description IntegerBreak
 * @author liubolun
 * @date 2019年12月18日 10:08
 * @version 3.1.1
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        boolean isC = false;
        int result = 1;
        while (n > 0) {
            if (n == 2) {
                if (isC) {
                    return result * 2;
                } else {
                    return result;
                }
            } else if (n == 3) {
                if (isC) {
                    return result * 3;
                } else {
                    return result * 2;
                }
            } else if (n < 6) {
                isC = true;
                n = n - 2;
                result *= 2;
            } else {
                isC = true;
                n = n - 3;
                result *= 3;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(9));
    }
}
