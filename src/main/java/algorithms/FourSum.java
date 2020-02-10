/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.FourSum
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * FourSum
 * @description TODO
 * @author liubolun
 * @date 2019年11月13日 22:38
 * @version 2.9
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>(0);
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int a = 0; a <= nums.length - 4; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            for (int b = a + 1; b <= nums.length - 3; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                int c = b + 1; int d = nums.length - 1;
                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
                        lists.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                        while (c < d && nums[c] == nums[c - 1]) {
                            c ++;
                        }
                        while (c < d && nums[d] == nums[d + 1]) {
                            d --;
                        }
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d --;
                    } else {
                        c ++;
                    }
                }
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] test = {0,0,0,0};
        fourSum.fourSum(test, 0);
    }
}
