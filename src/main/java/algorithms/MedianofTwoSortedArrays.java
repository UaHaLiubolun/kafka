package algorithms;

import java.util.*;

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

    public int myAtoi(String str) {
        int sign = 1, total = 0, index = 0;
        if(str.length() == 0) return 0;
        while(str.length() > index && str.charAt(index) == ' ') {
            index ++;
        }
        if (str.length() == index) return 0;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        int maxValue = Integer.MAX_VALUE;
        while(index < str.length()) {
            int dist = str.charAt(index) - '0';
            if (dist < 0 || dist > 9) break;

            if (maxValue / 10 < total || (maxValue / 10 == total && maxValue % 10 < dist)) {
                return sign == 1 ? maxValue : Integer.MIN_VALUE;
            }
            total = total * 10 + dist;
            index++;
        }
        return total * sign;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int r = 0;
        while (r < x) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        return x == r || r / 10 == x;
    }

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() == 0) return true;
        if (p.length() == 0) return false;
        int sIndex = 0, pIndex = 0;
        char c = p.charAt(pIndex);
        boolean isMore = false;
        while (pIndex < p.length() && sIndex < s.length()) {
            if (p.charAt(pIndex) != '*') {
                c = p.charAt(pIndex);
                isMore = false;
            } else {
                isMore = true;
            }

            if (s.charAt(sIndex) == c || c == '.') {
                if (!isMore) {
                    pIndex ++;
                }
                sIndex ++;
            } else {
                pIndex ++;
            }
        }
        return sIndex == s.length();
    }

    public boolean isMatchDP(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new LinkedList<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                int temp = list.indexOf(s.charAt(i));
                list = list.subList(temp + 1, list.size());
                list.add(s.charAt(i));
                maxLength = Math.max(maxLength, list.size());
            } else {
                list.add(s.charAt(i));
                maxLength = Math.max(maxLength, list.size());
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringV2(String A) {
        Map<Character, Integer> charPosition = new HashMap<>();
        //preArr代表以s[i-1]结尾的情况下，最长无重复子串的长度
        int[] preArr = new int[A.length()];

        char[] str2charArr = A.toCharArray();
        //从头到尾遍历str2charArr，统计出以每个字符为当前位置的向前最长无重复子串的长度
        for(int i=0; i<A.length(); i++){
            Integer lastPosOfChar = charPosition.get(str2charArr[i]);
            if(lastPosOfChar == null){//说明当前字符第一次出现
                //更新最长无重复子串的长度
                preArr[i] = i == 0 ? 1 : preArr[i-1] + 1;
                //记录当前字符出现的位置
                charPosition.put(str2charArr[i], i);
            }
            else{//当前字符不是第一次出现(既然不是第一次出现，那也不是在第一个位置),也就是之前出现过该字符
                //获取前一个字符最长无重复子串的长度
                int aPos = lastPosOfChar + 1;
                int unRepeatLen = preArr[i-1];
                int bPos = i - unRepeatLen;
                if(aPos >= bPos){
                    //当前位置的最长无重复子串长度
                    preArr[i] = i - aPos + 1;
                }
                else{
                    preArr[i] = i - bPos + 1;
                }
                charPosition.put(str2charArr[i], i);
            }
        }
        int max = preArr[0];
        for(int i: preArr) if(i > max) max = i;
        return max;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int i = 0;
        while (true) {
            if (strs[0].length() == i) return strs[0];
            char s = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i) {
                    return strs[j];
                }
                if (s != strs[j].charAt(i)) {
                    return i == 0 ? "" : strs[0].substring(0, i);
                }
            }
            i ++;
        }
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] charsS1 = s1.toCharArray();
        char[] charsS2 = s2.toCharArray();

        int[] count = new int[128];
        for (int i = 0; i < charsS1.length; i++) {
            count[charsS1[i] - 'a']++;
            count[charsS2[i] - 'a']--;
        }
        if (zeroCount(count)) return true;
        for (int i = charsS1.length; i < charsS2.length; i++) {
            count[charsS2[i] - 'a']--;
            count[charsS2[i - charsS1.length] - 'a']++;
            if (zeroCount(count)) return true;
        }
        return false;
    }

    private boolean zeroCount(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        return mult(num1, num2);
    }

    private String mult(String num1, String num2) {
        if (num1.length() == 1 && num2.length() == 1) {
            int temp = (num1.charAt(0) - '0') * (num2.charAt(0) - '0');
            return String.valueOf(temp);
        } else if (num1.length() == 1) {
            String tail = mult(num1, num2.substring(num2.length() - 1));
            String head = mult(num1, num2.substring(0, num2.length() - 1));
            return addString(tail, head + "0");
        } else{
            String tail = mult(num2, num1.substring(num1.length() - 1));
            String head = mult(num2, num1.substring(0, num1.length() - 1));
            return addString(tail, head + "0");
        }
    }

    private String addString(String num1, String num2) {
        int maxL;
        int c;
        if (num1.length() > num2.length()) {
            maxL = num1.length();
            c = maxL - num2.length();
        } else {
            maxL = num2.length();
            c = maxL - num1.length();
            String num3 = num1;
            num1 = num2;
            num2 = num3;
        }
        int j = 0;
        String result = "";
        for (int i = maxL - 1; i >= 0; i--) {
            int temp;
            if ((i - c) < 0) {
                temp = (num1.charAt(i) - '0') + j;
            } else {
                temp = (num1.charAt(i) - '0') + (num2.charAt(i - c) - '0') + j;
            }
            if (temp > 9) {
                j = 1;
            } else {
                j = 0;
            }
            result = (temp % 10) + result;
        }
        if (j == 1) result = 1 + result;
        return result;
    }

    public String multiplyV2(String num1, String num2) {
        int s1L = num1.length();
        int s2L = num2.length();
        int[] p = new int[s1L + s2L];

        for (int i = s1L - 1; i >= 0 ; i--) {
            for (int j = s2L - 1; j >= 0 ; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j; int p2 = p1 + 1;
                temp = p[p2] + temp;
                p[p1] += temp / 10;
                p[p2] = temp % 10;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < p.length; i++) {
            if(!(stringBuffer.length() == 0 && p[i] == 0)) stringBuffer.append(p[i]);
        }
        return stringBuffer.toString();
    }

    public String reverseWords(String s) {
        return null;
    }

    public String simplifyPath(String path) {
        String[] paths = path.split("/+");
        List<String> stringList = new LinkedList<>();
        int j = -1;
        for (int i = 1; i < paths.length; i++) {
            if (paths[i].equals(".")) {

            } else if (paths[i].equals("..")) {
                if (j >= 0) {
                    stringList.remove(j);
                    j--;
                }
            } else {
                stringList.add(paths[i]);
                j ++;
            }
        }
        if (j < 0) return "/";
        else {
            StringBuffer sb = new StringBuffer();
            for (String s:
                 stringList) {
                sb.append("/" + s);
            }
            return sb.toString();
        }
    }

    public List<String> restoreIpAddresses(String s) {

    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
        String[] s = {"dlower", "flow", "flight"};
        System.out.println(m.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}
