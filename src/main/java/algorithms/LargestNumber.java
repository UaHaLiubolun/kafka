/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.LargestNumber
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LargestNumber
 * @description TODO
 * @author liubolun
 * @date 2019年11月07日 21:26
 * @version 2.9
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, ((o1, o2) -> {
            long one = Long.parseLong(o1 + o2);
            long two = Long.parseLong(o2 + o1);
            return (int)(two - one);
        }));
        if (ss[0].equalsIgnoreCase("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i]);
        }
        return sb.toString();
    }

    class IntC implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }

}
