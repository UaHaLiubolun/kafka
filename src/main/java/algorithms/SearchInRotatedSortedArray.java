package algorithms;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int i = 0; int j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) return mid;
            else if (mid > 0 && mid < nums.length - 1 && nums[mid] < nums[mid + 1] && nums[mid] < nums[mid -1]) {
                if (nums[mid - 1] >= target && nums[j] < target ) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if ((target < nums[mid] && target >= nums[i])) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6,7,1,2,3,4,5};
        System.out.println(SearchInRotatedSortedArray.search(nums, 6));
    }
}
