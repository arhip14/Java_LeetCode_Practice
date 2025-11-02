import java.util.*;

public class EqualRowandColumnPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int count = 0;
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }
        for (int c = 0; c < n; c++) {
            int[] col = new int[n];
            for (int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }
            String key = Arrays.toString(col);

            if (rowMap.containsKey(key)) {
                count += rowMap.get(key);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        EqualRowandColumnPairs sol = new EqualRowandColumnPairs();

        int[][] grid1 = {{3,2,1},{1,7,6},{2,7,7}};
        int[][] grid2 = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        System.out.println(sol.equalPairs(grid1)); // 1
        System.out.println(sol.equalPairs(grid2)); // 3
    }
}