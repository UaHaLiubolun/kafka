/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.FindMin
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * FindMin
 * @description TODO
 * @author liubolun
 * @date 2019年11月11日 21:42
 * @version 2.9
 */
public class FindMin {

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid = 0;
        while (nums[start] >= nums[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                int min = nums[start];
                for (int i = start; i < end; i++) {
                    min = Math.min(nums[i], min);
                }
                return min;
            }
            if (nums[mid] >= nums[start]) {
                start = mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            }
        }
        return nums[mid];
    }
}
