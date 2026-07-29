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

        BoundedStack<Integer> stack = new BoundedStack<>(3);

        // Test 1
        check(stack.isEmpty(), "New stack is empty");

        // Test 2
        check(stack.size() == 0, "Initial size = 0");

        // Test 3
        stack.push(10);
            check(stack.size() == 1, "Push one item");

        // Test 4
        check(stack.peek() == 10, "Peek after one push");

        // Test 5
        stack.push(20);
            check(stack.peek() == 20, "Peek after second push");

    }
}