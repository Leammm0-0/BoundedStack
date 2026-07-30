public class BoundedStack<TJ> { // เก็บอะไรก็ได้ int string double
    
    /**
     * Abstraction Function (AF)
     * อาร์เรย์ elements[0..size-1] แทนข้อมูลทั้งหมดในstack
     * โดยข้อมูลบนสุด (Top) คือ elements[size-1]

     * Representation Invariant (RI)
     * - elements ต้องไม่เป็น null
     * - capacity ต้องมากกว่า 0
     * - size ต้องมีค่าอยู่ระหว่าง 0 ถึง capacity
     * - elements.length ต้องเท่ากับ capacity
     */

    private TJ[] elements;
    private int size;
    private int capacity;

    /**
     * Constructor
     * @param capacity ความจุของ stack
     * @throws IllegalArgumentException ถ้า capacity <= 0
     */

    public BoundedStack(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0") ;
        }

        this.capacity = capacity ;
        this.elements = (TJ[]) new Object[capacity] ;
        this.size = 0 ;

        checkRep();

    }

    private void checkRep() {

        assert elements != null ;
        assert capacity > 0 ;
        assert size >= 0 ;
        assert size <= capacity ;
        assert elements.length == capacity ;

    }

    /**
     * Push an item onto the stack
     * @param item the item to push
     * @throws IllegalStateException ถ้า stack เต็ม
     */

    public void push(TJ item) {

        if (size == capacity) {
            throw new IllegalStateException("Stack is full") ;
        }

        elements[size] = item ;
        size++ ;

        checkRep();
        
    }

    /**
     * Pop an item from the stack
     * @return the item that was popped
     * @throws IllegalStateException ถ้า stack ว่าง
     */

    public TJ pop() {
        
        if (size == 0) {
            throw new IllegalStateException("Stack is empty") ;
        }

        size-- ;
        TJ item = elements[size] ;
        elements[size] = null ;

        checkRep();

        return item ;

    }

    /**
     * Peek at the top item on the stack
     * @return the item at the top of the stack
     * @throws IllegalStateException ถ้า stack ว่าง
     */
    
    public TJ peek() {

        if (size == 0) {
            throw new IllegalStateException("Stack is empty") ;
        }

        return elements[size - 1] ;

    }

    /**
     * Create a copy of the stack
     * @return a new BoundedStack containing the same elements
     */
    
    public BoundedStack<TJ> copy() {

        BoundedStack<TJ> newStack = new BoundedStack<>(capacity) ;

        for (int i = 0; i < size; i++) {
            newStack.elements[i] = elements[i] ;
        }

        newStack.size = size ;
        newStack.checkRep();

        return newStack ;

    }

    /**
     * Check if the stack is empty
     * @return true if the stack is empty, false otherwise
     */

    public boolean isEmpty() {

        return size == 0 ;
    }

    /**
     * Check if the stack is full
     * @return true if the stack is full, false otherwise
     */

    public boolean isFull() {

        return size == capacity ;
    }

    /**
     * Get the number of items in the stack
     * @return the number of items in the stack
     */

    public int size() {

        return size ;
    }

}