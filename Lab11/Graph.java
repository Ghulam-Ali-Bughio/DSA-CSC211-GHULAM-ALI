/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graph;

/**
 *
 * @author ga408
 */

import java.util.*;


public class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;

   
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    
    public void addEdge(int u, int v) {
        adjacencyMatrix[u - 1][v - 1] = 1; 
    }

    
    public void displayMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

   
    public void findShortestPath(int start, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];

        Arrays.fill(parent, -1);
        visited[start - 1] = true;
        queue.add(start - 1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination - 1) {
                printShortestPath(start, destination, parent);
                return;
            }

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue.add(i);
                }
            }
        }
        System.out.println("No path found");
    }

    // Print the shortest path
    private void printShortestPath(int start, int destination, int[] parent) {
        List<Integer> path = new ArrayList<>();
        int current = destination - 1;

        while (current != -1) {
            path.add(current + 1);
            current = parent[current];
        }

        Collections.reverse(path);
        System.out.print("Shortest Path: ");
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
        System.out.println("\nLength: " + (path.size() - 1));
    }

    // Find all paths between two vertices using DFS
    public void findAllPaths(int start, int destination) {
        List<List<Integer>> allPaths = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        List<Integer> path = new ArrayList<>();
        dfs(start - 1, destination - 1, visited, path, allPaths);

        System.out.println("Paths:");
        for (List<Integer> p : allPaths) {
            System.out.print("Path: ");
            for (int vertex : p) {
                System.out.print(vertex + " ");
            }
            System.out.println("(Length: " + (p.size() - 1) + ")");
        }
    }

   
    private void dfs(int current, int destination, boolean[] visited, List<Integer> path, List<List<Integer>> allPaths) {
       
        visited[current] = true;
        path.add(current + 1);

        if (current == destination) {
            allPaths.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    dfs(i, destination, visited, path, allPaths);
                }
            }
        }

        path.remove(path.size() - 1);
        visited[current] = false;
    }

    
    public void findConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfsConnected(i, visited, component);
                components.add(component);
            }
        }

        System.out.println("Connected Components:");
        for (int i = 0; i < components.size(); i++) {
            System.out.print("Component " + (i + 1) + ": ");
            for (int vertex : components.get(i)) {
                System.out.print((vertex + 1) + " ");
            }
            System.out.println();
        }
    }

    
    private void dfsConnected(int current, boolean[] visited, List<Integer> component) {
        visited[current] = true;
        component.add(current + 1);

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                dfsConnected(i, visited, component);
            }
        }
    }

    
    public static void main(String[] args) {
        
       
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();
        Graph graph = new Graph(vertices);

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter edges (u, v) pairs:");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

       
        graph.displayMatrix();

        
        System.out.print("Enter start vertex for shortest path: ");
        int start = scanner.nextInt();
        System.out.print("Enter destination vertex for shortest path: ");
        int destination = scanner.nextInt();
        graph.findShortestPath(start, destination);

        
        System.out.print("Enter start vertex for all paths: ");
        start = scanner.nextInt();
        System.out.print("Enter destination vertex for all paths: ");
        destination = scanner.nextInt();
        graph.findAllPaths(start, destination);


        graph.findConnectedComponents();
       
       
        
    }
    
}
