/**
 *
 */
package utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utilitie.Iterator;
import utilitie.ListADT;
import DoubleLinkedList.DLL;

/**
 * @author 708114
 *
 */
public class DoubleLinkListTests {

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
		list = new DLL<>();
		s1 = "A";
		s2 = "B";
		s3 = "C";
		s4 = "D";
		sNull = null;
	}


	/**
	 * Test method for {@link DoubleLinkedList.DLL#size()}.
	 */
	@Test
	public void testSize() {
		list.add(s1);
		list.add(s2);
		assertEquals("Did't worked",2, list.size());
	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#clear()}.
	 * Testing the clear method
	 */
	@Test
	public void testClear() {
		list.add(s1);
		list.add(s2);
		list.clear();
		assertEquals("Didn't worked",0, list.size());
	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#add(int, java.lang.Object)}.
	 * testing index to add a certian index.
	 */
	@Test
	public void testAddIntE() {
		list.add(s1);
		list.add(s2);
		list.add(1,s3);
		assertEquals("Didn't worked",s3,list.get(1));
	}


	/**
	 * Test method for {@link DoubleLinkedList.DLL#add(int, java.lang.Object)}.
	 * testing index to get a indexOutOfBounds Excption.
	 */
	@Test
	public void testAddIntE1() {
		try {
		list.add(s1);
		list.add(s2);
		list.add(3,s3);
		fail("Fail to capture exception");
		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#add(int, java.lang.Object)}.
	 * testing index to get a NullPointerException
	 */
	@Test
	public void testAddIntE2() {
		try {
		list.add(s1);
		list.add(s2);
		list.add(2,sNull);
		fail("Fail to capture exception");
		}catch(NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#add(java.lang.Object)}.
	 * Appending to the bottom to the list.
	 */
	@Test
	public void testAddE() {
		list.add(s1);
		list.add(s2);
		assertEquals("Didn't worked",s2, list.get(1));
	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#addAll(utilitie.ListADT)}.
	 * testing to add another to another DLL.
	 */
	@Test
	public void testAddAll() {
		ListADT l = new DLL<>();
		list.add(s1);
		list.add(s2);
		l.addAll(list);
		assertEquals("Didn't work at all", s1, l.get(0));
		assertEquals("Didn't work at all", s2, l.get(1));

	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#addAll(utilitie.ListADT)}.
	 * testing to propogate out the Nullpounter exception.s
	 */
	@Test
	public void testAddAll1() {
		try {
		ListADT l = new DLL<>();
		list.add(s1);
		list.add(null);
		l.addAll(list);
		fail("Could not catch the excpetion.");
		}catch(NullPointerException e) {
			assertTrue(true);
		}

	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#get(int)}.
	 * testing to grab element from certain index
	 */
	@Test
	public void testGet() {
		list.add(s1);
		list.add(s2);
		list.add(s3);
		assertEquals("Didn't work",s2, list.get(1));
	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#get(int)}.
	 * testing to grab element from certain index
	 */
	@Test
	public void testGet1() {
		try {
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.get(4);
		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
//
	/**
	 * Test method for {@link DoubleLinkedList.DLL#remove(int)}.
	 * Testing index to reemove from the array
	 */
	@Test
	public void testRemoveInt() {
		list.add(s1);
		list.add(s3);
		list.add(s2);
		String r = list.remove(1);
		assertEquals("Size didn't change",2, list.size());
		assertEquals("Size didn't change",s3, r);


	}
	/**
	 * Test method for {@link DoubleLinkedList.DLL#remove(int)}.
	 * Testing to thow indexOutBounds
	 */
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
	 * Test method for {@link DoubleLinkedList.DLL#remove(java.lang.Object)}.
	 * Removing element from DLL with the given element.
	 */
	@Test
	public void testRemoveE() {
		list.add(s1);
		list.add(s3);
		list.add(s2);
		String r = list.remove(s1);
		assertEquals("Size didn't change",2, list.size());
		assertEquals("Size didn't change",s1, r);
	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#set(int, java.lang.Object)}.
	 * testing to set element at a gievn index.
	 */
	@Test
	public void testSet() {
		list.add(s1);
		list.add(s3);
		list.add(s2);
		list.set(1,s4);
		assertEquals("Size didn't change",s4, list.get(1));
	}
	/**
	 * Test method for {@link DoubleLinkedList.DLL#set(int, java.lang.Object)}.
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
	 * Test method for {@link DoubleLinkedList.DLL#isEmpty()}.
	 * Testing to see if the array is empty.
	 */
	@Test
	public final void testIsEmpty() {
		list.add(s1);
		list.remove(s1);

		assertEquals("List is not empty", 0,list.size());
	}


	/**
	 * Test method for {@link DoubleLinkedList.DLL#contains(java.lang.Object)}.
	 * Test to see if certian element is exist in the array.
	 */
	@Test
	public final void testContains() {
		 list.add(s1);
		 assertTrue(list.contains(s1));
	}

	/**
	 * Test method for {@link DoubleLinkedList.DLL#toArray(E[])}.
	 * Convert the Double linked List to array.
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
	 * Test method for {@link DoubleLinkedList.DLL#toArray(E[])}.
	 * Checking to see if the to array can handle null values
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
	 * Test method for {@link DoubleLinkedList.DLL#toArray()}.
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
	 * Test method for {@link DoubleLinkedList.DLL#iterator()}.
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
