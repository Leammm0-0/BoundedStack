    /**
     * BoundedStack ระบบบันทึกคำค้นหาย้อนหลัง
     */

    // 6821651221 นาย ทรงกฤษ เหลี่ยมคุณ No.22 801

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
     * สร้าง stack ที่มีความจุสูงสุดเท่ากับ capacity
     * @param capacity ความจุสูงสุดของ stack
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

    /**
     * ตรวจสอบ Representation Invariant (RI)
     * สมาชิกของ stack ต้องไม่เป็น null 
     * capacity ต้องมากกว่า 0
     * size ต้องอยู่ระหว่าง 0 ถึง capacity
     * elements.length ต้องเท่ากับ capacity
     * @throws AssertionError ถ้า RI ไม่เป็นจริง
     */

    private void checkRep() {

        assert elements != null ;
        assert capacity > 0 ;
        assert size >= 0 ;
        assert size <= capacity ;
        assert elements.length == capacity ;

    }

    /**
     * เอาข้อมูลใส่เข้าไปใน stack
     * @param item ข้อมูลที่จะ push เข้าไปใน stack
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
     * เอาข้อมูลออกจาก stack
     * @return ข้อมูลที่อยู่บนสุดของ stack
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
     * ดูข้อมูลที่อยู่บนสุดของ stack แต่ไม่เอาออก
     * @return ข้อมูลที่อยู่บนสุดของ stack
     * @throws IllegalStateException ถ้า stack ว่าง
     */
    
    public TJ peek() {

        if (size == 0) {
            throw new IllegalStateException("Stack is empty") ;
        }

        return elements[size - 1] ;

    }

    /**
     * สร้าง stack ใหม่ที่มีข้อมูลเหมือนกับตัวเดิม
     * @return stack ใหม่ที่มีข้อมูลเหมือนกับตัวเดิม
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
     * เช็คว่า stack ว่างมั้ย
     * @return true ถ้า stack ว่าง, false ถ้าไม่ว่าง
     */

    public boolean isEmpty() {

        return size == 0 ;
    }

    /**
     * เช็คว่า stack เต็มมั้ย
     * @return true ถ้า stack เต็ม, false ถ้าไม่เต็ม
     */

    public boolean isFull() {

        return size == capacity ;
    }

    /**
     * เช็คว่าใน stack มีข้อมูลอยู่กี่ตัว
     * @return จำนวนข้อมูลใน stack
     */

    public int size() {

        return size ;
    }

}