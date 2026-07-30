public class BoundedStack<TJ> { // เก็บอะไรก็ได้ int string double
    
    /*
     * Abstraction Function (AF)
       อาร์เรย์ elements[0..size-1] แทนข้อมูลทั้งหมดในstack
       โดยข้อมูลบนสุด (Top) คือ elements[size-1]

     * Representation Invariant (RI)
       - elements ต้องไม่เป็น null
       - capacity ต้องมากกว่า 0
       - size ต้องมีค่าอยู่ระหว่าง 0 ถึง capacity
       - elements.length ต้องเท่ากับ capacity
     */

    private TJ[] elements;
    private int size;
    private int capacity;

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

    public void push(TJ item) {

        if (size == capacity) {
            throw new IllegalStateException("Stack is full") ;
        }

        elements[size] = item ;
        size++ ;

        checkRep();
        
    }

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

    public TJ peek() {

        if (size == 0) {
            throw new IllegalStateException("Stack is empty") ;
        }

        return elements[size - 1] ;

    }

    public BoundedStack<TJ> copy() {

        BoundedStack<TJ> newStack = new BoundedStack<>(capacity) ;

        for (int i = 0; i < size; i++) {
            newStack.elements[i] = elements[i] ;
        }

        newStack.size = size ;
        newStack.checkRep();

        return newStack ;

    }

    public boolean isEmpty() {

        return size == 0 ;
    }

    public boolean isFull() {

        return size == capacity ;
    }

    public int size() {

        return size ;
    }

}