/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.ThreeSumClosest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ThreeSumClosest
 * @description TODO
 * @author liubolun
 * @date 2019年11月13日 21:58
 * @version 2.9
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start ++;
                } else {
                    return min;
                }
            }
        }
        return min;
    }



    public static void main(String[] args) {
        ThreeSumClosest sumClosest = new ThreeSumClosest();
        int[] test = {-1,2,1,-4};
        sumClosest.threeSumClosest(test, 1);
    }
}
