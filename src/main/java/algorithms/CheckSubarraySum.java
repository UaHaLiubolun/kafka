/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.CheckSubarraySum
 * @copyright Copyright 2020 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * CheckSubarraySum
 * @description TODO
 * @author liubolun
 * @date 2020年01月02日 16:37
 * @version 3.1.1
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum+= nums[j];
                if (k == 0) {
                    if (sum == 0) {
                        return true;
                    }
                    continue;
                }
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
