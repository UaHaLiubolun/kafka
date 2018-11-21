package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1; int k = nums.length - 1;
            int target = nums[i];
            while (j < k) {
                if (nums[j] + nums[k] + target == 0) {
                    res.add(Arrays.asList(target, nums[j], nums[k]));
                    j ++;
                    k --;
                    while (j < k && nums[j] == nums[j - 1]) j ++;
                    while (j < k && nums[k] == nums[k + 1]) k --;
                } else if (nums[j] + nums[k] + target < 0) {
                    j ++;
                } else {
                    k --;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(ThreeSum.threeSum(nums));
    }

}
