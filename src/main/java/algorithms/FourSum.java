/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.FourSum
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import sun.tools.jstat.Literal;

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
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        findFour(nums, target, lists, new LinkedList<>(), 4, 0);
        return lists;
    }

    private void findFour(int[] nums, int target, List<List<Integer>> lists, List<Integer> integers, int k, int index) {
        if (k == 0 && target == 0) {
            lists.add(integers);
            return;
        }
        if (k == 0) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] < target) {
                List<Integer> newI = new LinkedList<>(integers);
                newI.add(nums[i]);
                findFour(nums, target - nums[i], lists, newI, k - 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] test = {1,0,-1,0,-2,2};
        fourSum.fourSum(test, 0);
    }
}
