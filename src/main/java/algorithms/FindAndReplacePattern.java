/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.FindAndReplacePattern
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * FindAndReplacePattern
 * @description TODO
 * @author liubolun
 * @date 2019年10月29日 16:35
 * @version 3.0.0
 */
public class FindAndReplacePattern {


    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new LinkedList<>();
        String patternIndex = getIndex(pattern);
        for (String word : words) {
            if (getIndex(word).equals(patternIndex)) {
                result.add(word);
            }
        }
        return result;
    }

    private String getIndex(String word) {
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        int current = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars){
            final int ii = current++;
            Integer i = map.computeIfAbsent(c, o -> ii);
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
