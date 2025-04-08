package LabFive;
import java.util.*;

public class ComponentsTwoSolution {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private List<List<Integer>> components;

    public void findComponents(int n, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n];
        components = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, component);
                components.add(component);
            }
        }

        System.out.println(components.size());
        for (List<Integer> component : components) {
            System.out.println(component.size());
            for (int vertex : component) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    private void dfs(int vertex, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, component);
            }
        }
    }
}
