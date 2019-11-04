/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.MaxDistToClosest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

/**
 * MaxDistToClosest
 * @description TODO
 * @author liubolun
 * @date 2019年11月03日 17:22
 * @version 2.9
 */
public class MaxDistToClosest {

    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int start = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (start == 0) {
                    max = Math.max(i - start, max);
                } else {
                    if ((i - start) % 2 != 0) {
                        max = Math.max((i - start) / 2 + 1, max);
                    } else {
                        max = Math.max((i - start) / 2, max);
                    }
                }
                start = i + 1;
            }
            if (i == seats.length - 1) {
                max = Math.max(i - start, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxDistToClosest maxDistToClosest = new MaxDistToClosest();
        int[] i = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest.maxDistToClosest(i));
    }
}
