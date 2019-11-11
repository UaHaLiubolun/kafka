/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.SingleNumber
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * SingleNumber
 * @description TODO
 * @author liubolun
 * @date 2019年11月11日 20:33
 * @version 2.9
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> one = new HashSet<>();
        Set<Integer> two = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            two.add(nums[i]);
            if (!one.add(nums[i])) {
                two.remove(nums[i]);
            }
        }
        return two.iterator().next();
    }
}
