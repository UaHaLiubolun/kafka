package algorithms;

public class MedianofTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int min = 0, max = m, half = (m + n + 1) / 2;
        while (min <= max) {
            int i = (min + max) / 2, j = half - i;
            if (i < max && nums2[j - 1] > nums1[i]) {
                min = i + 1;
            } else if (i > min && nums1[i - 1] > nums2[j]) {
                max = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) maxLeft = nums2[j -1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2 == 1) return maxLeft;

                int minRight = 0;
                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2.0;
            }

        }
        return 0.0;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode c = new ListNode(0);
        ListNode h = c;
        int deep = 0;
        while (a != null || b!= null || deep == 1) {
            ListNode temp = null;
            int tmp = 0;
            if (a == null && b == null) {
                tmp = deep;
            } else if (a == null) {
                tmp = deep + b.val;
                b = b.next;
            } else if (b == null) {
                tmp = deep + a.val;
                a = a.next;
            } else {
                tmp = a.val + b.val + deep;
                a = a.next;
                b = b.next;
            }
            if (tmp >= 10) {
                deep = 1;
            } else {
                deep = 0;
            }
            temp = new ListNode(tmp % 10);
            h.next = temp;
            h = h.next;
        }
        return c.next;
    }


    public int reverse(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }


    private ListNode temp(String val) {
        int length = val.length();
        if (length == 1) {
            return new ListNode(Integer.parseInt(val));
        } else {
            ListNode temp = new ListNode(Integer.parseInt(val.substring(length - 1, length)));
            temp.next = temp(val.substring(0, length - 1));
            return temp;
        }
    }

    private ListNode temp2(String val) {
        int length = val.length();
        if (length == 1) {
            return new ListNode(Integer.parseInt(val));
        } else {
            ListNode temp = new ListNode(Integer.parseInt(val.substring(0, 1)));
            temp.next = temp(val.substring(1));
            return temp;
        }
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
        System.out.println(m.reverse(1534236469));
    }
}
