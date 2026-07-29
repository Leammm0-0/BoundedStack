public class TestBoundedStack {

    private static int passed = 0;
    private static int failed = 0;

    public static void check(boolean condition, String testName) {

        if (condition) {
            System.out.println("PASS : " + testName);
            passed++;

        } else {
            System.out.println("FAIL : " + testName);
            failed++;
            
        }
    }

    public static void main(String[] args) {

    }
}