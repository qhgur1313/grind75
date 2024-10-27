import java.util.LinkedList;
import java.util.Queue;

public class P542 {
  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] result = new int[m][n];
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 1) {
          result[i][j] = Integer.MAX_VALUE;
        } else {
          queue.add(new int[] {i, j});
        }
      }
    }

    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!queue.isEmpty()) {
      int[] que = queue.poll();
      int val = result[que[0]][que[1]];
      for (int[] dir : directions) {
        int row = que[0] + dir[0];
        int col = que[1] + dir[1];
        if (row >= 0 && row < m && col >= 0 && col < n) {
          if (result[row][col] > val + 1) {
            result[row][col] = val + 1;
            queue.add(new int[] {row, col});
          }
        }
      }
    }
    return result;
  }
}
