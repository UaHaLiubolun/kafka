/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.NumsSameConsecDiff
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * NumsSameConsecDiff
 * @description TODO
 * @author liubolun
 * @date 2019年10月29日 17:24
 * @version 3.0.0
 */
public class NumsSameConsecDiff {

    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            numsSame(result, sb, N, K);
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    private void numsSame(List<Integer> set, StringBuilder s, int n, int k) {
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
                    return;
                } else {
                    numsSame(set, s, n, k);
                }
            }
            if (s.length() == n) {
                return;
            }
            int newNumTwo = num - k;
            if (newNumTwo >= 0) {
                s.append(newNumTwo);
                if (s.length() == n) {
                    set.add(Integer.parseInt(s.toString()));
                    return;
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
