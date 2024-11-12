package src.java.bfs;

import src.java.utils.MyQueue;

public class BFS {
    private final int[][] adMatrix = {{0,0,0,0,0,0,0,0}, {0,0,1,1,1,0,0,0}, {0,1,0,1,0,0,0,0}, {0,1,1,0,1,1,0,0}, {0,1,0,1,0,1,0,0}, {0,0,0,1,1,0,1,1}, {0,0,0,0,0,1,0,1}, {0,0,0,0,0,1,1,0}};
    private final MyQueue queue = new MyQueue();
    private final int n = adMatrix[0].length;
    private final int[] visited = new int[n];
    public static void main(String[] args) {
        traverse(1);
    }

    private static void traverse(int i) {
        BFS bfs = new BFS();
        System.out.print("{ ");
        System.out.print(i + " ");
        bfs.queue.enqueue(i);
        bfs.visited[i] = 1;
        while (!bfs.queue.isEmpty()) {
            int u = bfs.queue.dequeue();
            for (int v=1; v<bfs.n; v++) {
                if (bfs.adMatrix[u][v] == 1 && bfs.visited[v] == 0) {
                    System.out.print(v + " ");
                    bfs.visited[v] = 1;
                    bfs.queue.enqueue(v);
                }
            }
        }
        System.out.println("}");
    }
}
