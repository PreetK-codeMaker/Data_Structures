/**
 *
 */
package utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import MyArrayList.MyArrayList;
import utilitie.Iterator;
import utilitie.ListADT;

/**
 * @author 708114
 *
 */
public class MyArrayListTests {
	//Attributes
	private ListADT<String> list;
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String sNull;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpBeforeClass() throws Exception {
		list = new MyArrayList<>();
		s1 = "A";
		s2 = "B";
		s3 = "C";
		s4 = "D";
		sNull = null;
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#size()}.
	 * This method check the size of the array by add to String
	 */
	@Test
	public final void testSize() {
		list.add(s1);
		list.add(s2);
		assertEquals("Didn't change the size",2,list.size());
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#clear()}.
	 * This mehtod add to String in the array then clears
	 */
	@Test
	public final void testClear() {
		list.add(s1);
		list.add(s2);
		list.clear();
		assertEquals("Didn't change the size",0,list.size());
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public final void testAddIntE() {

		list.add(0,s1);
		assertEquals("Didn't add to the array",s1, list.get(0));
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#add(java.lang.Object)}.
	 * This method append to the bottom of the list
	 */
	@Test
	public final void testAddE() {
		list.add(s1);
		list.add(s2);
		assertEquals("Didn't worked", s2,list.get(1));
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#addAll(utilitie.ListADT)}.
	 *
	 */
	@Test
	public final void testAddAll() {
		ListADT l = new MyArrayList<>();
		list.add(s1);
		list.add(s2);
		l.addAll(list);
		assertEquals("Didn't work at all", s1, l.get(0));
		assertEquals("Didn't work at all", s2, l.get(1));

	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#get(int)}.
	 * Retrieve the element at a given index.
	 */
	@Test
	public final void testGet() {
		list.add(s1);
		list.add(s2);
		assertEquals("Didn't work at all", s2, list.get(list.size()-1));
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#remove(int)}.
	 * Removing element from given index.
	 */
	@Test
	public final void testRemoveInt() {

			list.add(s1);
			list.add(s3);
			list.add(s2);
			String r = list.remove(1);
			assertEquals("Size didn't change",2, list.size());
			assertEquals("Size didn't change",s3, r);

	}

	@Test
	public final void testRemoveInt1() {
		try {
			list.remove(0);
			fail("Failed to remove");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#remove(java.lang.Object)}.
	 * Removing element from given array.
	 */
	@Test
	public final void testRemoveE() {
		list.add(s1);
		list.add(s3);
		list.add(s2);
		String r = list.remove(s1);
		assertEquals("Size didn't change",2, list.size());
		assertEquals("Size didn't change",s1, r);

	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#set(int, java.lang.Object)}.
	 * Setting element at a certian index List is not empty.
	 */
	@Test
	public final void testSet() {
		list.add(s1);
		list.add(s3);
		list.add(s2);
		list.set(1,s4);
		assertEquals("Size didn't change",s4, list.get(1));

	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#set(int, java.lang.Object)}.
	 * test to see if the null pointer exception is thrown.
	 */
	@Test
	public final void testSet2() {
		try {
			list.add(sNull);
			fail("Exception wasn't thrown");

		}catch(NullPointerException e) {
			assertTrue(true);
		}

	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#isEmpty()}.
	 * Testing to see if the array is empty.
	 */
	@Test
	public final void testIsEmpty() {
		list.add(s1);
		list.remove(s1);

		assertEquals("List is not empty", 0,list.size());
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#contains(java.lang.Object)}.
	 * Test to see if certian element is exist in the array.
	 */
	@Test
	public final void testContains() {
		 list.add(s1);
		 assertTrue(list.contains(s1));
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#toArray(E[])}.
	 * Convert the arraylist to array.
	 */
	@Test
	public final void testToArrayEArray() {
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		String arr [] = new String[0];
		arr = list.toArray(arr);
		assertEquals("Didn't worked", s1,arr[0]);
		assertEquals("Didn't worked", s2,arr[1]);
		assertEquals("Didn't worked", s3,arr[2]);
		assertEquals("Didn't worked", s4,arr[3]);
		assertEquals("Didn't worked", list.size(),arr.length);


	}
	/**
	 * Test method for {@link MyArrayList.MyArrayList#toArray(E[])}.
	 * Checing to see if the to array can handle null values
	 */
	@Test
	public final void testToArrayEArray1() {
		try {
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(sNull);
		String arr [] = new String[0];
		arr = list.toArray(arr);
		assertEquals("Didn't worked", s1,arr[0]);
		assertEquals("Didn't worked", s2,arr[1]);
		assertEquals("Didn't worked", s3,arr[2]);
		assertEquals("Didn't worked", s4,arr[3]);
		assertEquals("Didn't worked", list.size(),arr.length);
		fail("Didn't not worked0");
		}catch (NullPointerException e) {
			assertTrue(true);
		}


	}


	/**
	 * Test method for {@link MyArrayList.MyArrayList#toArray()}.
	 * Converting the array list to an Object array.
	 */
	@Test
	public final void testToArray() {
		list.add(s1);
		list.add(s2);
		list.add(s3);
		Object [] arr = list.toArray();
		assertEquals("Didn't worked", s1,arr[0]);
		assertEquals("Didn't worked", s2,arr[1]);
		assertEquals("Didn't worked", s3,arr[2]);
		assertEquals("Didn't worked", list.size(),arr.length);
	}

	/**
	 * Test method for {@link MyArrayList.MyArrayList#iterator()}.
	 */
	@Test
	public final void testIterator() {
		list.add(s1);
		list.add(s2);
		list.add(s3);
		Iterator<String> it = list.iterator();
		assertEquals("Didn't Worked",s1 ,it.next());
		assertEquals("Didn't Worked",s2 ,it.next());
		assertEquals("Didn't Worked",s3 ,it.next());

	}

}
