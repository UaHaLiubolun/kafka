/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.MaxProfit
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * MaxProfit
 * @description TODO
 * @author liubolun
 * @date 2019年11月26日 15:41
 * @version 3.1.1
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit  = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
