/*
 * @projectName kafak
 * @package algorithms
 * @className algorithms.MaxProduct
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package algorithms;


/**
 * MaxProduct
 * @description TODO
 * @author liubolun
 * @date 2019年11月26日 14:44
 * @version 3.1.1
 */
public class MaxProduct {

    public int maxProduct(String[] words) {
        int maxI = 0;
        int[] w = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int value = 0;
            for (int j = 0; j < words[i].length(); j++) {
                value |= 1 << (words[i].charAt(j) - 'a');
            }
            w[i] = value;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                if ((w[i] & w[j]) == 0) {
                    maxI = Math.max(words[i].length() * words[j].length(), maxI);
                }
            }
        }
        return maxI;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"}));
    }
}
