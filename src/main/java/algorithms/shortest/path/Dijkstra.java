package algorithms.shortest.path;


public class Dijkstra {
    private int max = Integer.MAX_VALUE;
    private boolean[] visited = new boolean[100];
    private int[] dist = new int[100]; // 原点到i顶点的最短距离
    private int[] pre = new int[100]; // 记录最短路径。pre[i]放的是i的前驱节点
    void solve(int[][] matrix) {
        // 从第一个点出发
        visited[0] = true;
        // 计算其他点到第一个点的距离
        for (int i = 0; i < matrix.length; i++) {
            dist[i] = matrix[0][i];
            pre[i] = 0;
        }
        int min_cos;
        int min_cos_index = 0;
        for (int i = 1; i < matrix.length; i++) {
            min_cos = max;
            // 找出到i点的最短距离
            for (int j = 0; j < matrix.length; j++) {
                if (!visited[j] && dist[j] < min_cos) {
                    min_cos = dist[j];
                    min_cos_index = j;
                }
            }
            visited[min_cos_index] = true; // 将最小距离点加入visited
            for (int j = 0; j < matrix.length; j++) {
                // 重新计算最短距离 更新dist
                if (!visited[j] && matrix[min_cos_index][j] != max &&
                        min_cos + matrix[min_cos_index][j] < dist[j]) {
                    dist[j] = min_cos + matrix[min_cos_index][j];
                    pre[j] = min_cos_index;
                }
            }
        }
    }


   private int[][] getGroup() {
       int[][] result = {
               {0, 1, 5, max, max, max, max, max, max},
               {1, 0, 3, 7, 5, max, max, max, max},
               {5, 3, 0, max, 1, 7, max, max, max},
               {max, 7, max, 0, 2, max, 3, max, max},
               {max, 5, 1, 2, 0, 3, 6, 9, max},
               {max, max, 7, max, 3, 0, max ,5, max},
               {max, max, max, 3, 6, max, 0, 2, 7},
               {max, max, max, max, 9, 5, 2, 0, 4},
               {max, max, max, max, max, max, 4, 6, 0}
       };
       return result;
   }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        int[][] result = dijkstra.getGroup();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].length);
        }
        dijkstra.solve(result);
        for (int i = 0; i < result.length; i++) {
            System.out.println(dijkstra.dist[i]);
        }
    }
}