/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.MinAreaRect
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * MinAreaRect
 * @description TODO
 * @author liubolun
 * @date 2019年11月13日 21:13
 * @version 2.9
 */
public class MinAreaRect {

    public int minAreaRect(int[][] points) {
        if (points.length < 4) return 0;
        List<Integer> result = new LinkedList<>();
        findMin(0, 4, points, new LinkedList<>(), result);
        if (result.isEmpty()) return 0;
        else {
            result.sort(Integer::compareTo);
            return result.get(0);
        }
    }

    private void findMin(int index, int k, int[][] points, List<int[]> current, List<Integer> result) {
        for (int i = index; i < points.length; i++) {
            if (k == 0) {
                current.sort(((o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }));
                if (current.get(0)[0] == current.get(1)[0] && current.get(1)[1] == current.get(3)[1]
                    && current.get(3)[0] == current.get(2)[0] && current.get(2)[1] == current.get(0)[1]) {
                    result.add((current.get(3)[0] - current.get(0)[0]) * (current.get(3)[1] - current.get(0)[1]));
                }
            } else {
                current.add(points[i]);
                List<int[]> newList = new LinkedList<>(current);
                findMin(i + 1, k - 1, points, newList, result);
            }
        }
    }

    public static void main(String[] args) {
        MinAreaRect minAreaRect = new MinAreaRect();
        int[][] test = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        minAreaRect.minAreaRect(test);
    }
}
