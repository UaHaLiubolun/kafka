/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.NumsSameConsecDiff
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.*;

/**
 * NumsSameConsecDiff
 * @description TODO
 * @author liubolun
 * @date 2019年10月29日 17:24
 * @version 3.0.0
 */
public class NumsSameConsecDiff {

    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            numsSame(result, sb, N, K);
        }
        if (N == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(0);
            numsSame(result, sb, N, K);
        }
        int[] r = new int[result.size()];
        Iterator<Integer> integerIterator = result.iterator();
        int i = 0;
        while (integerIterator.hasNext()) {
            r[i] = integerIterator.next();
            i++;
        }
        Arrays.sort(r);
        return r;
    }

    private void numsSame(Set<Integer> set, StringBuilder s, int n, int k) {
        if (s.length() == n) {
            set.add(Integer.parseInt(s.toString()));
            return;
        }
        for (int i = 0; i < 10; i++) {
            int num = s.charAt(s.length() - 1) - '0';
            int newNumOne = num + k;
            if (newNumOne <= 9) {
                s.append(newNumOne);
                if (s.length() == n) {
                    set.add(Integer.parseInt(s.toString()));
                    s.deleteCharAt(s.length() - 1);
                } else {
                    numsSame(set, s, n, k);
                }
            }
            int newNumTwo = num - k;
            if (newNumTwo >= 0) {
                s.append(newNumTwo);
                if (s.length() == n) {
                    set.add(Integer.parseInt(s.toString()));
                    s.deleteCharAt(s.length() - 1);
                } else {
                    numsSame(set, s, n, k);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumsSameConsecDiff numsSameConsecDiff = new NumsSameConsecDiff();
        int[] i = numsSameConsecDiff.numsSameConsecDiff(4, 1);
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
    }

}
