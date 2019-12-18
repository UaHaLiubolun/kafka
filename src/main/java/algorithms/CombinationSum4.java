/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.CombinationSum4
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * CombinationSum4
 * @description CombinationSum4
 * @author liubolun
 * @date 2019年12月17日 15:48
 * @version 3.1.1
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    private void combination(int[] nums, int index, int target, List<Integer> list) {
        for (int i = index; i < nums.length; i++) {
            if (target == nums[index]) {
                list.add(nums[index]);
            } else if (target > nums[index]) {
                combination(nums, i, target - nums[index], list);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum4.combinationSum4(nums, 4));
    }
}
