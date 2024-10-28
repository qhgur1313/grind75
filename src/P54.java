import java.util.ArrayList;
import java.util.List;

public class P54 {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    System.out.println(spiralOrder(arr));

  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    List<Integer> result = new ArrayList<>();
    int dir = 0;
    int x = -1;
    int y = 0;
    int upperBorder = 1;
    int belowBorder = matrix.length - 1;
    int leftBorder = 0;
    int rightBorder = matrix[0].length - 1;
    while (true) {
      int[] direction = directions[dir];
      if (dir == 0) {
        while (x < rightBorder) {
          x += direction[1];
          y += direction[0];
          result.add(matrix[y][x]);
        }
        rightBorder -= 1;

      } else if (dir == 1) {
        while (y < belowBorder) {
          x += direction[1];
          y += direction[0];
          result.add(matrix[y][x]);
        }
        belowBorder -= 1;
      } else if (dir == 2) {
        while (x > leftBorder) {
          x += direction[1];
          y += direction[0];
          result.add(matrix[y][x]);
        }
        leftBorder += 1;
      } else {
        while (y > upperBorder) {
          x += direction[1];
          y += direction[0];
          result.add(matrix[y][x]);
        }
        upperBorder += 1;

      }

      dir++;
      if (dir == 4) {
        dir = 0;
      }
      if (result.size() == matrix.length * matrix[0].length) {
        break;
      }
    }
    return result;
  }
}
