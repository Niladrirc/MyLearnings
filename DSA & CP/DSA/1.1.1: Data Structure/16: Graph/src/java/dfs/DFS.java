package src.java.dfs;

public class DFS {
    private static final int[][] adMatrix = {{0,0,0,0,0,0,0,0}, {0,0,1,1,1,0,0,0}, {0,1,0,1,0,0,0,0}, {0,1,1,0,1,1,0,0}, {0,1,0,1,0,1,0,0}, {0,0,0,1,1,0,1,1}, {0,0,0,0,0,1,0,1}, {0,0,0,0,0,1,1,0}};
    private static final int n = adMatrix[0].length;
    private static final int[] visited = new int[n];
    public static void main(String[] args) {
        System.out.print("{ ");
        traverse(2);
        System.out.println(" }");
    }

    private static void traverse(int u) {
        if (visited[u] == 0) {
            visited[u] = 1;
            System.out.print(u+" ");
            for (int v=1; v<n; v++) {
                if (adMatrix[u][v] == 1 && visited[v] == 0) {
                    traverse(v);
                }
            }
        }
    }
}
