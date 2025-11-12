package RottingOranges;

import java.util.*;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Збираємо початкові гнилі апельсини та рахуємо свіжі
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];

                    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1) continue;

                    grid[r][c] = 2;
                    fresh--;
                    rottedThisRound = true;
                    queue.offer(new int[]{r, c});
                }
            }

            if (rottedThisRound) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges solver = new RottingOranges();

        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solver.orangesRotting(grid1));

        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(solver.orangesRotting(grid2));

        int[][] grid3 = {{0,2}};
        System.out.println(solver.orangesRotting(grid3));
    }
}

//You are given an m x n grid where each cell can have one of three values:
//
//        0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//        Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
//
//
//
//Example 1:
//
//
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
//Example 2:
//
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
//        Example 3:
//
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 10
//grid[i][j] is 0, 1, or 2.