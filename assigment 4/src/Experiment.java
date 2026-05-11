import java.util.Random;

public class Experiment {
    public void run() {
        runDemo();
        runPerformanceTest();
    }

    private void runDemo() {
        System.out.println("\n--- Part 1: demonstration ---");
        Graph g = new Graph();
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");

        g.addEdge(v0, v1);
        g.addEdge(v1, v2);
        g.addEdge(v2, v0);

        g.printGraph();
        g.bfs(v0);
        g.dfs(v0);
    }

    private void runPerformanceTest() {
        System.out.println("\n--- Part 2: performnce ---");
        int[] sizes = {10, 30, 100};
        System.out.printf("%-10s | %-15s | %-15s\n", "Nodes", "BFS (ns)", "DFS (ns)");

        for (int n : sizes) {
            Graph g = new Graph();
            Vertex[] vrs = new Vertex[n];
            for(int i=0; i<n; i++) {
                vrs[i] = new Vertex(String.valueOf(i));
                g.addVertex(vrs[i]);
            }
            Random r = new Random();
            for(int i=0; i < n*2; i++) {
                g.addEdge(vrs[r.nextInt(n)], vrs[r.nextInt(n)]);
            }
            long startB = System.nanoTime();
            g.bfsPerformance(vrs[0]);
            long endB = System.nanoTime();

            long startD = System.nanoTime();
            g.dfsPerformance(vrs[0]);
            long endD = System.nanoTime();

            System.out.printf("%-10d | %-15d | %-15d\n", n, (endB - startB), (endD - startD));
        }
    }
}