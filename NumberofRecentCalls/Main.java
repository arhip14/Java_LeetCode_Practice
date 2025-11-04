package NumberofRecentCalls;

public class Main {
    public static void main(String[] args) {
        NumberofRecentCalls obj = new NumberofRecentCalls();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}