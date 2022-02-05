/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import static org.junit.Assert.*;
import org.junit.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class ReverseArrayListTester {

    private MyArrayList numsArrayList, stringsArrayList, emptArrayList;

    Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
    String[] strings = {"upside", "fliping", "backwards", "reverse"};
    Object[] empty = {};

    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        numsArrayList = new MyArrayList<>(nums);
        stringsArrayList = new MyArrayList<>(strings);
        emptArrayList = new MyArrayList<>(empty);
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testReverseIndexOutOfBounds(){
		try{
            numsArrayList.reverseRegion(-2, 3);
        }catch(IndexOutOfBoundsException e){
			throw e;
		}
		fail("Exception not catched");    
    }

    /**
     * Tests reverseRegion method when called on empty Arraylist with bounds
     * eqaul
     */
    @Test
    public void testReverseEmptyArrayList(){
        emptArrayList.reverseRegion(0, 0);
        for(int i = 0; i < emptArrayList.size(); i++){
            assertEquals(i+1, emptArrayList.get(i));
        }
    }
    
    /**
     * Tests reverseRegion method when called on empty Arraylist with wrong
     * bounds
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testReverseEmptyArrayListWrongBounds(){
		try{
            emptArrayList.reverseRegion(0, 1);
        }catch(IndexOutOfBoundsException e){
			throw e;
		}
		fail("Exception not catched");    
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        numsArrayList.reverseRegion(4, 3);
        for(int i = 0; i < numsArrayList.size(); i++){
            assertEquals(i+1, numsArrayList.get(i));
        }
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds
    */
    @Test
    public void testReverseIndexWithinBounds(){
        numsArrayList.reverseRegion(1, 4);
        assertEquals(1, numsArrayList.get(0));
        assertEquals(5, numsArrayList.get(1));
        assertEquals(4, numsArrayList.get(2));
        assertEquals(3, numsArrayList.get(3));
        assertEquals(2, numsArrayList.get(4));
        assertEquals(6, numsArrayList.get(5));
        assertEquals(7, numsArrayList.get(6));
        //reverse back
        numsArrayList.reverseRegion(1, 4);
        assertEquals(1, numsArrayList.get(0));
        assertEquals(2, numsArrayList.get(1));
        assertEquals(3, numsArrayList.get(2));
        assertEquals(4, numsArrayList.get(3));
        assertEquals(5, numsArrayList.get(4));
        assertEquals(6, numsArrayList.get(5));
        assertEquals(7, numsArrayList.get(6));
        //reverse the whole thing
        numsArrayList.reverseRegion(0, 6);
        assertEquals(7, numsArrayList.get(0));
        assertEquals(6, numsArrayList.get(1));
        assertEquals(5, numsArrayList.get(2));
        assertEquals(4, numsArrayList.get(3));
        assertEquals(3, numsArrayList.get(4));
        assertEquals(2, numsArrayList.get(5));
        assertEquals(1, numsArrayList.get(6));
        //calling it on strings
        stringsArrayList.reverseRegion(1, 3);
        assertEquals("upside", stringsArrayList.get(0));
        assertEquals("reverse", stringsArrayList.get(1));
        assertEquals("backwards", stringsArrayList.get(2));
        assertEquals("fliping", stringsArrayList.get(3));
    }

    /**
     * Custom test
    */
    @Test
    public void testReverseCustom(){
        //TODO: Add your test case

    }


}
