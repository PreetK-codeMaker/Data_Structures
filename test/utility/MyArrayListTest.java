package utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MyArrayList.MyArrayList;
import utilitie.ListADT;

public class MyArrayListTest {
	//attributes
	private ListADT<String> list;
	private String s1;
	private String s2;
	private String s3;
	private String sNull;
	@Before
	public void setUp() throws Exception{
		list=new MyArrayList<String>();
		s1 = "A";
		s2 = "B";
		s3 = "C";
		sNull = null;
	}

	/**
	 * test methods for {@link utitlity}
	 * List is empty , adding to index 0
	 */
	@Test
	public void testAddIntE() {
		list.add(0,s1);
		//1 what we expect and next ione is what is should be.
		assertEquals("Size didn't change",1,list.size());
		assertEquals("Didn't add the elemenet", s1,list.get(0));

	}

	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty only one element, adding to index 0
	 */
	@Test
	public void testAddIntE2() {
		list.add(s2);
		list.add(0,s1);
		//1 what we expect and next ione is what is should be.
		assertEquals("Size didn't change",2,list.size());
		assertEquals("Didn't add the elemenet", s1,list.get(0));

	}

	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty only one element, adding to index 1 (size)
	 */
	@Test
	public void testAddIntE3() {
		list.add(s1);
		list.add(list.size(),s2);
		//1 what we expect and next ione is what is should be.
		assertEquals("Size didn't change",2,list.size());
		assertEquals("Didn't add the elemenet", s2,list.get(list.size()-1));

	}

	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty more then one element, adding to index 0
	 */
	@Test
	public void testAddIntE4() {
		list.add(s2);
		list.add(s3);
		list.add(0,s1);
		list.add(list.size(),s2);
		//1 what we expect and next ione is what is should be.
		assertEquals("Size didn't change",4,list.size());
		assertEquals("Didn't add the elemenet", s1,list.get(0));

	}

	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty more then one element, adding to index size
	 */
	@Test
	public void testAddIntE5() {
		list.add(s1);
		list.add(s2);
		list.add(list.size(),s3);
		//1 what we expect and next ione is what is should be.
		assertEquals("Size didn't change",3,list.size());
		assertEquals("Didn't add the elemenet", s3,list.get(list.size()-1));

	}


	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty more then one element, adding to index 1
	 */
	@Test
	public void testAddIntE6() {
		list.add(s1);
		list.add(s3);
		list.add(1,s2);
		//1 what we expect and next ione is what is should be.
		assertEquals("Size didn't change",3,list.size());
		assertEquals("Didn't add the elemenet", s2,list.get(1));

	}


	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty more then one element, adding a null
	 */
	@Test
	public void testAddIntE7() {
		try {
			list.add(s1);
			list.add(s2);
			list.add(0,sNull);
			fail("NullPointerException wasn't thrown");

		}catch(NullPointerException e) {
			assertTrue(true);
		}

	}


	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty more then one element, adding to index -1
	 */
	@Test
	public void testAddIntE8() {
		try {
			list.add(s1);
			list.add(s2);
			list.add(-1,sNull);
			fail("IndexOutBound wasn't thrown");

		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}


	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty more then one element, adding to index +1
	 */
	@Test
	public void testAddIntE9() {
		try {
			list.add(s1);
			list.add(s2);
			list.add(list.size()+1,sNull);
			fail("IndexOutBound wasn't thrown");

		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}

	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is empty add a null;
	 */
	@Test
	public void testAddIntE10() {
		try {

			list.add(0,sNull);
			fail("NullPointerException wasn't thrown");

		}catch(NullPointerException e) {
			assertTrue(true);
		}

	}



	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is not empty more then one element, adding to index -1
	 */
	@Test
	public void testAddIntE11() {
		try {

			list.add(-1,sNull);
			fail("IndexOutBound wasn't thrown");

		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}


	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * List is empty add a null;
	 */
	@Test
	public void testAddIntE12() {
		try {

			list.add(list.size()+1,s3);
			fail("IndexOutBound wasn't thrown");

		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}

//
//	@Test
//	public void testAddE() {
//		fail("Not yet implemented");
//	}

	/*
	 *
	 * */

	@Test
	public void testRemoveInt1() {
		try {
		list.remove(0);
		fail("IndexOutBound wasn't thrown");

		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}


	/*
	 * List is not empty contains one elements
	 */

	@Test
	public void testRemoveInt2() {

			list.add(s1);
			String removed = list.remove(0);
			assertEquals("Size didn't chane", 0,list.size());
			assertEquals("the specified item wasn't removed.", s1, removed);

	}



	/*
	 * List is not empty contains more then one element, removing index 0
	 */

	@Test
	public void testRemoveInt3() {

			list.add(s1);
			list.add(s2);
			list.add(s3);
			String removed = list.remove(0);
			assertEquals("Size didn't chane", 2,list.size());
			assertEquals("the specified item wasn't removed.", s1, removed);

	}


	/*
	 * List is not empty contains more then one element, removing index size -1
	 */

	@Test
	public void testRemoveInt4() {

			list.add(s1);
			list.add(s2);
			list.add(s3);
			String removed = list.remove(list.size()-1);
			assertEquals("Size didn't chane", 2,list.size());
			assertEquals("the specified item wasn't removed.", s3, removed);

	}

	/*
	 * List is not empty contains more then one element, removing index size 1
	 */

	@Test
	public void testRemoveInt5() {

			list.add(s1);
			list.add(s2);
			list.add(s3);
			String removed = list.remove(1);
			assertEquals("Size didn't chane", 2,list.size());
			assertEquals("the specified item wasn't removed.", s2, removed);

	}


	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * LList is not empty contains more then one element, removing index  -1
	 */
	@Test
	public void testRemoveInt6() {

			list.add(s1);
			list.add(s2);
			list.add(s3);

		try {
			list.remove(-1);
			fail("IndexOutBound wasn't thrown");

		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}

	/**
	 * test methods for {@link utitlity.MyArrayList#add(int, java.lang.Object)}.
	 * LList is not empty contains more then one element, removing index size
	 */
	@Test
	public void testRemoveInt7() {

			list.add(s1);
			list.add(s2);
			list.add(s3);

		try {
			list.remove(list.size());
			fail("IndexOutBound wasn't thrown");

		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}

	}


}
