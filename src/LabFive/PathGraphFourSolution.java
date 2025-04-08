package LabFive;

import java.util.*;

public class PathGraphFourSolution {
    private List<List<Integer>> graph;
    private boolean[] visited;
    private int[] parent;
    private Queue<Integer> queue;

    public void findShortestPath(int n, int[][] matrix, int start, int end) {
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
        queue = new LinkedList<>();

        Arrays.fill(parent, -1);
        queue.offer(start - 1);
        visited[start - 1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end - 1) {
                printPath(start - 1, end - 1);
                return;
            }

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println(-1);
    }

    private void printPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        int current = end;

        while (current != start) {
            path.add(current + 1);
            current = parent[current];
        }

        path.add(start + 1);
        Collections.reverse(path);

        System.out.println(path.size() - 1);
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
    }
}
