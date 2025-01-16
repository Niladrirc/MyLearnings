package src.java.kruskal;

import java.util.Arrays;

public class KruskalsAlgorithm {
    private static final int[][] edge = new int[3][9];
    private static final int[][] t = new int[2][6];
    private static final int[] set = new int[8];
    private static final int[] included = new int[9];
    private static int prevMin = Integer.MIN_VALUE;
    public static void main(String[] args) {
        populateEdge();
        populateSet();
        findSpanningTree();
        System.out.println(Arrays.deepToString(t));
    }

    private static void findSpanningTree() {
        int tIndex = 0;
        while (tIndex < t[0].length) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j=0; j<edge[2].length; j++){
                if (edge[2][j] < min && edge[2][j] > prevMin) {
                    min = edge[2][j];
                    minIndex = j;
                }
            }

            // Check if j is included
            if (included[minIndex] == 0) {
                included[minIndex] = 1;
            } else {
                continue;
            }

            // Check if it is forming a loop
            int u = edge[0][minIndex];
            int v = edge[1][minIndex];
            if (find(u) == find(v)) {
                System.out.println(u + ", " + v+" will form a loop ignoring");
                prevMin = min;
                continue;
            } else {
                t[0][tIndex] = u;
                t[1][tIndex] = v;

                // Perform weighted union
                union(find(u), find(v));
            }
            prevMin = min;
            tIndex += 1;
        }
    }

    private static void union(int u, int v) {
        if (set[u] < set[v]) {
            set[u] = set[u]+set[v];
            set[v] = u;
        } else {
            set[v] = set[v]+set[u];
            set[u] = v;
        }
    }

    private static int find(int u) {
        int temp = u;
        while (set[temp] > 0) {
            temp = set[temp];
        }
        return temp;
    }

    private static void populateEdge() {
        edge[0] = new int[]{1, 2, 3, 4, 4, 5, 5, 6, 7};
        edge[1] = new int[]{2, 3, 4, 7, 5, 7, 6, 1, 2};
        edge[2] = new int[]{25,12,8,14,16,18,20,5,10};
    }

    private static void populateSet() {
        Arrays.fill(set, -1);
    }
}
