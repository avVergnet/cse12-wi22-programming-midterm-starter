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

    private MyArrayList numsArrayList, stringsArrayList;

    Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
    String[] strings = {"upside", "fliping", "backwards", "reverse"};

    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        numsArrayList = new MyArrayList<>(nums);
        stringsArrayList = new MyArrayList<>(strings);
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
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        numsArrayList.reverseRegion(4, 3);
        assertEquals(numsArrayList, numsArrayList);
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
    } //    String[] strings = {"upside", "fliping", "backwards", "reverse"};

    /**
     * Custom test
    */
    @Test
    public void testReverseCustom(){
        //TODO: Add your test case

    }


}
