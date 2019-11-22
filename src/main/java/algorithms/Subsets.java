/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.Subsets
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Subsets
 * @description TODO
 * @author liubolun
 * @date 2019年11月22日 15:18
 * @version 3.1.1
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        subset(result, new LinkedList<>(), 0, nums);
        return result;
    }

    private void subset(List<List<Integer>> result, List<Integer> current, int index, int[] nums) {
        result.add(current);
        for (int i = index; i < nums.length; i++) {
            List<Integer> now = new LinkedList<>(current);
            now.add(nums[i]);
            subset(result, now, i + 1, nums);
        }
    }
}
