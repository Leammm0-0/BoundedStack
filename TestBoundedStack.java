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

        // Test 6
        check(stack.peek() == 10, "Peek returns top");

        // Test 7
        check(stack.pop() == 10, "Pop returns top");

        // Test 8
        check(stack.isEmpty(), "Stack empty after pop");

        // Test 9
        check(stack.peek() == 20, "Peek after pop");

        // Test 10
        check(stack.size() == 2, "Size after pop");

        // Test 11
        check(!stack.isEmpty(), "Stack not empty");

        // Test 12
        stack.pop();
        stack.pop();
            check(stack.isEmpty(), "Empty after removing all");

        // Test 13
        boolean exceptionThrown = false;
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            exceptionThrown = true;
        }
        
            check(exceptionThrown, "Pop empty stack");

        // Test 14
        exceptionThrown = false;
        try {
            stack.peek();
        } catch (IllegalStateException e) {
            exceptionThrown = true;
        }

            check(exceptionThrown, "Peek empty stack");

        // Test 15
        stack.push(100);
            check(stack.peek() == 100, "Push after empty");

    }
}