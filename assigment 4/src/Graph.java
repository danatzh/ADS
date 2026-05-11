import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex destination) {
        if (!adjList.containsKey(source)) addVertex(source);
        if (!adjList.containsKey(destination)) addVertex(destination);
        adjList.get(source).add(destination);
    }

    public void bfs(Vertex start) {
        if (start == null || !adjList.containsKey(start)) return;

        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.getId() + " ");

            for (Vertex neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(Vertex start) {
        if (start == null || !adjList.containsKey(start)) return;

        Set<Vertex> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }
    // Добавь это в Graph.java
    public void bfsPerformance(Vertex start) {
        if (start == null || !adjList.containsKey(start)) return;
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Vertex neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void dfsPerformance(Vertex start) {
        if (start == null || !adjList.containsKey(start)) return;
        dfsHelperPerformance(start, new HashSet<>());
    }

    private void dfsHelperPerformance(Vertex current, Set<Vertex> visited) {
        visited.add(current);
        for (Vertex neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelperPerformance(neighbor, visited);
            }
        }
    }

    private void dfsHelper(Vertex current, Set<Vertex> visited) {
        visited.add(current);
        System.out.print(current.getId() + " ");

        for (Vertex neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
    public void printGraph() {
        System.out.println("Graph Structure (Adjacency List):");
        for (Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey().getId() + ": ");
            for (Vertex neighbor : entry.getValue()) {
                System.out.print(neighbor.getId() + " ");
            }
            System.out.println();
        }
    }
}