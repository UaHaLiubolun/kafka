/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.RemoveDuplicates
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * RemoveDuplicates
 * @description TODO
 * @author liubolun
 * @date 2019年11月03日 17:09
 * @version 2.9
 */
public class RemoveDuplicates {

    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        char c = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == c) {
                return removeDuplicates(S.substring(0, i - 1) + S.substring(i + 1));
            } else {
                c = S.charAt(i);
            }
        }
        return S;
    }

    public String removeDuplicates2(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (sb.length() == 0) {
                sb.append(S.charAt(i));
            } else if (S.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates2("abbaca"));
    }

}
