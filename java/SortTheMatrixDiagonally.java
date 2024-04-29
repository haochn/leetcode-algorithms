import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 1329. 将矩阵按对角线排序
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 */
public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (m == 1 || n == 1) {
            return mat;
        }
        // 有 m+n-1 个对角线
        int dLen = m + n - 1;

        ArrayList<Integer>[] diagonal = new ArrayList[dLen];
        for (int i = 0; i < dLen; i++) {
            diagonal[i] = new ArrayList<>();
        }

        // 同一对角线下标的j-i=k，k区间为[-(m-1),n-1]，偏移 m-1，即[0,n+m-2]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagonal[j - i + (m - 1)].add(mat[i][j]);
            }
        }

        for (int i = 0; i < dLen; i++) {
            Collections.sort(diagonal[i]);
        }

        int[] next = new int[dLen];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = j - i + (m - 1);
                mat[i][j] = diagonal[index].get(next[index]);
                next[index]++;
            }
        }

        return mat;
    }
}
