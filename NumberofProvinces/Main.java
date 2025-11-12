import NumberofProvinces.NumberofProvinces;

public class Main {
    public static void main(String[] args) {
        NumberofProvinces solution = new NumberofProvinces();
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int provinces = solution.findCircleNum(isConnected);
        System.out.println("Number of provinces: " + provinces);
    }
}