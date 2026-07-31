public class TestBoundedStack {

    private static int pass = 0;
    private static int fail = 0;

    public static void check(boolean condition, String testName) {

        if (condition) {
            System.out.println("PASS : " + testName);
            pass++;

        } else {
            System.out.println("FAIL : " + testName);
            fail++;
            
        }
    }

    public static void main(String[] args) {

        BoundedStack<String> stack = new BoundedStack<>(3);

        // Test 1 ตรวจว่า stack ที่สร้างขึ้นเป็นช่องว่างมั้ย
        check(stack.isEmpty(), "New stack is empty");

        // Test 2 ตรวจว่า stack ที่สร้างขึ้นมีขนาดเท่ากับ 0 มั้ย
        check(stack.size() == 0, "Initial size = 0");

        // Test 3 ตรวจว่าเมื่อ push 10 เข้าไปแล้ว stack เป็น 1 มั้ย
        stack.push("10");
            check(stack.size() == 1, "Push one item");

        // Test 4 ตรวจว่าเมื่อ push 10 เข้าไปแล้วตัวบนสุดจะเป็น 10 มั้ย
        check(stack.peek().equals("10"), "Peek after one push");

        // Test 5 ตรวจว่าเมื่อ push 20 เข้าไปแล้วตัวบนสุดจะเป็น 20 มั้ย
        stack.push("20");
            check(stack.peek().equals("20"), "Peek after second push");

        // Test 6 ตรวจว่าเมื่อมีข้อมูล 2 ตัวจากความจุ 3 stack ยังไม่เต็ม
        check(!stack.isFull(), "Stack is not full");

        // Test 7 ตรวจว่าเมื่อ pop ออกไปแล้วมันจะ return ตัวบนสุดออกมาจิงๆ
        check(stack.pop().equals("20"), "Pop returns top");

        // Test 8 ตรวจว่าเมื่อ pop ออกไปแล้ว stack ไม่ใช่ช่องว่าง
        check(!stack.isEmpty(), "Stack not empty after pop");

        // Test 9 ตรวจว่าเมื่อ pop ออกไปแล้วตัวบนสุดจะเป็น 10 มั้ย
        check(stack.peek().equals("10"), "Peek after pop");

        // Test 10 ตรวจว่าเมื่อ pop ออกไปแล้ว stack มีขนาดเท่ากับ 1 มั้ย
        check(stack.size() == 1, "Size after pop");

        // Test 11 ตรวจว่าเมื่อ pop ออกไปแล้ว stack จะไม่เต็ม
        check(!stack.isFull(), "Stack not full after pop");

        // Test 12 ตรวจว่าเมื่อ pop ออกไปแล้วไปหมดแล้ว stack จะว่างมั้ย
        stack.pop();
            check(stack.isEmpty(), "Empty after removing all");

        // Test 13 ตรวจว่าเมื่อ pop ออกจาก stack ที่ว่างจะเกิด exception มั้ย
        boolean exceptionThrown = false;
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            exceptionThrown = true;
        }

            check(exceptionThrown, "Pop empty stack");

        // Test 14 ตรวจว่าเมื่อลอง peek ตอน stack ว่างจะเกิด exception มั้ย
        exceptionThrown = false;
        try {
            stack.peek();
        } catch (IllegalStateException e) {
            exceptionThrown = true;
        }

            check(exceptionThrown, "Peek empty stack");

        // Test 15 ตรวจว่าเมื่อ push 100 เข้าไปแล้วตัวบนสุดจะเป็น 100 มั้ย
        stack.push("100");
            check(stack.peek().equals("100"), "Push after empty");

        // Test 16 ตรวจว่าเมื่อ push 3 ตัวเข้าไปแล้ว push 400 เข้ามาอีกจะเกิด exception มั้ย
        stack.push("200");
        stack.push("300");

        exceptionThrown = false;

        try {
            stack.push("400");
        } catch (IllegalStateException e) {
            exceptionThrown = true;
        }

            check(exceptionThrown, "Push full stack");

        // Test 17 ตรวจว่าเมื่อสร้าง stack ใหม่จะว่างมั้ย
        BoundedStack<String> stack2 = new BoundedStack<>(1);
        
        check(stack2.isEmpty(), "Capacity 1 stack");

        // Test 18 ตรวจว่าเมื่อ push 99 เข้าไปแล้ว stack จะเต็มมั้ย
        stack2.push("99");

        check(stack2.isFull(), "Capacity 1 becomes full");

        // Test 19 ตรวจว่าเมื่อ pop ออกไปแล้วจะได้ 99 มั้ย
        check(stack2.pop().equals("99"), "Pop only item");

        // Test 20 ตรวจว่าเมื่อสร้าง stack ด้วย capacity = 0 จะเกิด exception มั้ย
        exceptionThrown = false;

        try {
            new BoundedStack<String>(0);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }

            check(exceptionThrown, "Constructor capacity = 0");

        // Test 21 ตรวจว่าการ copy stack จะได้ stack ใหม่ที่มี element เหมือนกัน
        BoundedStack<String> original = new BoundedStack<>(3);
        original.push("10");
        original.push("20");

        BoundedStack<String> copied = original.copy();

        check(copied.size() == original.size(), "Copy has same size");

        // Test 22 ตรวจว่าการ copy stack จะได้ element บนสุดเหมือนกัน
        check(copied.peek().equals(original.peek()), "Copy has same top element");

        // Test 23 ตรวจว่าการ push ไปยัง stack ที่ copy จะไม่กระทบกับ stack ต้นฉบับ
        copied.push("30");

        check(original.size() == 2, "Original unchanged after modifying copy");

        // Test 24 ตรวจว่าเมื่อ copy stack ที่ว่างแล้ว stack ที่ copy ยังว่าง
        BoundedStack<String> emptyStack = new BoundedStack<>(3);
        BoundedStack<String> emptyCopy = emptyStack.copy();

        check(emptyCopy.isEmpty(), "Copy of empty stack is empty");


    System.out.println("\n==================================");
    System.out.printf("Part A : PASS %d / FAIL %d%n", pass, fail);
    System.out.println("==================================\n");

    }
}