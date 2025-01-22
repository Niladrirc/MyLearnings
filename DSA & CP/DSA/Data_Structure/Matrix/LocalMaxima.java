import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * UBER test question
 */
public class LocalMaxima {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,0,0,0,0}, {0,0,1,0,0}, {0,0,2,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,3,0,0,3}};

        int[][] result = solution(matrix);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] solution(int[][] matrix) {
        List<int[]> localMaximaIndices = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (isLocalMaxima(i, j, matrix) && matrix[i][j] != 0) {
                    localMaximaIndices.add(new int[]{i, j});
                }
            }
        }

        int[][] res = new int[localMaximaIndices.size()][1];
        for (int i = 0; i < res[0].length; i++) {
            res[i] = localMaximaIndices.get(i);
        }
        return res;
    }

    private static boolean isLocalMaxima(int i, int j, int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int value = matrix[i][j];
        int regionSize = ((value * 2) + 1)/2;

        for (int offsetI = -regionSize; offsetI <= regionSize ; offsetI++) {
            for (int offsetJ = -regionSize; offsetJ <= regionSize; offsetJ++) {
                if (offsetI == 0 && offsetJ == 0)
                    continue;

                int actualI = i + offsetI;
                int actualJ = j + offsetJ;

                if ((actualI == (regionSize)-i && actualJ == (regionSize)-j) ||
                        (actualI == (regionSize)-i) && (actualJ == regionSize) ||
                        (actualI == regionSize && actualJ == (regionSize)-j) ||
                        (actualI == regionSize && actualJ == regionSize)
                ) continue;

                if (actualI>=0 && actualI<rows && actualJ>=0 && actualJ<columns) {
                    if (matrix[actualI][actualJ] >= value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
