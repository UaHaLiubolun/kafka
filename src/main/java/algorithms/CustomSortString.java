/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.CustomSortString
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * CustomSortString
 * @description TODO
 * @author liubolun
 * @date 2019年11月03日 17:56
 * @version 2.9
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        char[] tArray = T.toCharArray();
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < tArray.length ; j++) {
                if (S.charAt(i) == tArray[j]) {
                    char temp = tArray[j];
                    tArray[j] = tArray[index];
                    tArray[index] = temp;
                    index++;
                }
            }
        }
        return new String(tArray);
    }

    public String customSortString2(String S, String T) {
        int[] sort = new int[26];
        for (int i = 0; i < S.length(); i++) {
            sort[S.charAt(i) - 'a'] = i;
        }
        char[][] result = new char[26][T.length()];
        for (int i = 0; i < T.length(); i++) {
            char[] temp = result[sort[T.charAt(i) - 'a']];
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == 0) {
                    temp[j] = T.charAt(i);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] != 0) {
                    sb.append(result[i][j]);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSortString sortString = new CustomSortString();
        System.out.println(sortString.customSortString2("cba", "abcd"));
    }
}
