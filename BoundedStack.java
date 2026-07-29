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

}