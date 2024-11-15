package src.java.prim;

import java.util.Arrays;

public class PrimsAlgorithm {
    private static final Integer Inf = Integer.MAX_VALUE;
    private static final int[][] adMatrix = new int[8][8];
    private static final int[] near = new int[]{Inf, Inf, Inf, Inf, Inf, Inf, Inf, Inf };
    private static final int[][] edge = new int[2][6];
    public static void main(String[] args) {
        populateMatrices();
        getEdges();
        System.out.println(Arrays.deepToString(edge));
    }

    private static void getEdges() {
        int min = Inf, u=0, v=0;
        for (int i = 1; i < adMatrix.length; i++) {
            for (int j=i; j<adMatrix[i].length; j++) {
                if (adMatrix[i][j] < min) {
                    min = adMatrix[i][j];
                    u = i;
                    v = j;
                }
            }
        }

        edge[0][0]=u;
        edge[1][0]=v;
        near[u] = 0;
        near[v] = 0;

        // Setup next
        for (int i = 1; i < near.length; i++) {
            if (near[i] != 0) {
                if (adMatrix[i][u] < adMatrix[i][v]) {
                    near[i] = u;
                } else {
                    near[i] = v;
                }
            }
        }


        int i=0;
        for (i = 1; i < edge[0].length; i++) {
            min = Inf;
            int k=0;
            for (int j=1; j<near.length; j++) {
                if (near[j] != 0) {
                    if (adMatrix[j][near[j]] < min) {
                        min = adMatrix[j][near[j]];
                        k = j;
                    }
                }
            }

            edge[0][i] = k;
            edge[1][i] = near[k];
            near[k] = 0;

            // Update near
            for (int j=1; j<near.length; j++) {
                if (near[j] != 0) {
                    if (adMatrix[j][near[j]] > adMatrix[j][k]) {
                        near[j] = k;
                    }
                }
            }
        }
    }

    private static void populateMatrices() {
        adMatrix[0] = new int[]{Inf, Inf, Inf, Inf, Inf, Inf, Inf, Inf};
        adMatrix[1] = new int[]{Inf, Inf, 25, Inf, Inf, Inf, 6, Inf};
        adMatrix[2] = new int[]{Inf, 25, 12, Inf, Inf, Inf, Inf, 10};
        adMatrix[3] = new int[]{Inf, Inf, 12, Inf, 8, Inf, Inf, Inf};
        adMatrix[4] = new int[]{Inf, Inf, Inf, 8, Inf, 16, Inf, 14};
        adMatrix[5] = new int[]{Inf, Inf, Inf, Inf, 16, Inf, 20, 18};
        adMatrix[6] = new int[]{Inf, 5, Inf, Inf, Inf, 20, Inf, Inf};
        adMatrix[7] = new int[]{Inf, Inf, 10, Inf, 14, 18, Inf, Inf};
    }
}
