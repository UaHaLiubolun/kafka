package sort;

public class Bubble {

    private void sort(int[] ints) {
        boolean flag = true;
        for (int i = 0; i < ints.length && flag; i++) {
            flag = false;
            for (int j = ints.length - 2; j >= i; j--) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    private void selectSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int k = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[k] > ints[j]) {
                    k = j;
                }
            }
            int temp = ints[k];
            ints[k] = ints[i];
            ints[i] = temp;
        }
    }

    private void insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int get = ints[i];                 // 右手抓到一张扑克牌
            int j = i - 1;                  // 拿在左手上的牌总是排序好的
            while (j >= 0 && ints[j] > get)    // 将抓到的牌与手牌从右向左进行比较
            {
                ints[j + 1] = ints[j];            // 如果该手牌比抓到的牌大，就将其右移
                j--;
            }

            ints[j + 1] = get;
        }
    }


    private void printArray(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] temp = {3, 5, 2,10, 1, 20, 100, 22, 334, 23, 12, 54, 52, 623, 514, 5423, 2341, 4521, 4232, 24353, 1123, 2323, 1231, 54523, 46262, 1213};
        bubble.insertSort(temp);
        bubble.printArray(temp);
    }
}
