package LabFive;

public class RoomThreeSolution {
    private char[][] maze;
    private boolean[][] visited;
    private int n;

    public int findRoomArea(int n, String[] mazeStr, int[] start) {
        this.n = n;
        maze = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            maze[i] = mazeStr[i].toCharArray();
        }

        return dfs(start[0] - 1, start[1] - 1);
    }

    private int dfs(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) return 0;
        if (maze[row][col] == '*' || visited[row][col]) return 0;

        visited[row][col] = true;

        int area = 1;
        area += dfs(row - 1, col);
        area += dfs(row + 1, col);
        area += dfs(row, col - 1);
        area += dfs(row, col + 1);

        return area;
    }
}
