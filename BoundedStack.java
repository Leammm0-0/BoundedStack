    /**
     * BoundedStack ระบบบันทึกคำค้นหาย้อนหลัง
     */

    // 6821651221 นาย ทรงกฤษ เหลี่ยมคุณ No.22 801

public class BoundedStack<TJ> { // เก็บข้อมูลได้หลายชนิด int string double
    
    /**
     * Abstraction Function (AF)
     * BoundedStack แทนระบบบันทึกคำค้นหาย้อนหลัง
     * โดย elements[0..size-1] แทนคำค้นหาที่ถูกบันทึกไว้
     * และ elements[size-1] คือคำค้นหาล่าสุด
     *
     * Representation Invariant (RI)
     * - elements ต้องไม่เป็น null
     * - capacity ต้องมากกว่า 0
     * - size ต้องอยู่ระหว่าง 0 ถึง capacity
     * - elements.length ต้องเท่ากับ capacity
     */

    private TJ[] elements;
    private int size;
    private int capacity;

    /**
     * สร้าง stack ที่มีความจุสูงสุดเท่ากับ capacity
     * capacity ต้องมากกว่า 0
     * 
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
     * - elements ต้องไม่เป็น null 
     * - capacity ต้องมากกว่า 0
     * - size ต้องอยู่ระหว่าง 0 ถึง capacity
     * - elements.length ต้องเท่ากับ capacity
     * 
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
     * stack ต้องไม่เต็ม
     * size ต้องน้อยกว่า capacity
     * item จะถูกเพิ่มไว้บนสุดของ stack
     * size จะเพิ่มขึ้น 1
     * 
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
     * stack ต้องไม่ว่าง
     * size ต้องมากกว่า 0
     * ข้อมูลบนสุดของ stack จะถูกเอาออกและคืนค่า
     * size จะลดลง 1
     * 
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
     * stack ต้องไม่ว่าง
     * size ต้องมากกว่า 0
     * คืนค่าข้อมูลบนสุดของ stack
     * stack ไม่เปลี่ยนแปลง
     * size ไม่เปลี่ยนแลง
     * 
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
     * stack ใหม่จะมีข้อมูลเหมือนกับ stack เดิม
     * stack ลำดับข้อมูลเหมือนกับ stack เดิม
     * size ของ stack ใหม่เท่ากับ size ของ stack เดิม
     * stack เดิมจะไม่เปลี่ยนแปลง
     * 
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
     * คืนค่า true ถ้า stack ว่าง size == 0
     * คืนค่าfalse ถ้าไม่ว่าง size > 0
     * 
     * @return true ถ้า stack ว่าง, false ถ้าไม่ว่าง
     */

    public boolean isEmpty() {

        return size == 0 ;
    }

    /**
     * เช็คว่า stack เต็มมั้ย
     * คืนค่า true ถ้า stack เต็ม size == capacity
     * คืนค่า false ถ้าไม่เต็ม size < capacity
     * 
     * @return true ถ้า stack เต็ม, false ถ้าไม่เต็ม
     */

    public boolean isFull() {

        return size == capacity ;
    }

    /**
     * เช็คว่าใน stack มีข้อมูลอยู่กี่ตัว
     * คืนค่าจำนวนข้อมูลปัจจุบันใน stack
     * stack จะไม่เปลี่ยนแปลง
     * 
     * @return จำนวนข้อมูลใน stack
     */

    public int size() {

        return size ;
    }

}