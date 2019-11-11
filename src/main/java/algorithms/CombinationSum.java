/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.CombinationSum
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * CombinationSum
 * @description TODO
 * @author liubolun
 * @date 2019年11月11日 21:06
 * @version 2.9
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        find(result, 0, target, candidates, new LinkedList<>());
        return result;
    }

    private void find(List<List<Integer>> result, int index, int target, int[] candidates, List<Integer> current) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == target) {
                current.add(candidates[i]);
                result.add(current);
            } else if (candidates[i] < target) {
                List<Integer> integerList = new LinkedList<>(current);
                integerList.add(candidates[i]);
                find(result, i, target - candidates[i], candidates, integerList);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        find(result, 1, n, k, new LinkedList<>());
        return result;
    }

    private void find(List<List<Integer>> result, int index, int target, int k,  List<Integer> current) {
        for (int i = index; i < 10; i++) {
            if (target == i && k == 0) {
                current.add(i);
                result.add(current);
            } else if (i < target && k != 0) {
                List<Integer> integerList = new LinkedList<>(current);
                integerList.add(i);
                find(result, i + 1, target - i, k - 1, integerList);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum3(3, 7);
    }
}
