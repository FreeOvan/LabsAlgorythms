package LabFive;

import java.util.*;

public class FindCycleFiveSolution {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private int[] parent;
    private List<Integer> cycle;

    public void findCycle(int n, int[][] matrix) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        visited = new boolean[n];
        parent = new int[n];
        cycle = new ArrayList<>();

        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }

        if (cycle.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(cycle.size());
            for (int vertex : cycle) {
                System.out.print((vertex + 1) + " ");
            }
        }
    }

    private void dfs(int vertex, int prev) {
        visited[vertex] = true;

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                parent[neighbor] = vertex;
                dfs(neighbor, vertex);
            } else if (neighbor != prev && parent[vertex] != neighbor) {
                cycle.clear();
                cycle.add(neighbor);
                int current = vertex;
                while (current != neighbor) {
                    cycle.add(current);
                    current = parent[current];
                }
                cycle.add(neighbor);
                return;
            }
        }
    }
}
