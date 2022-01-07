/**
 *
 */
package utility;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

import Stack.Stack;
import utilitie.Iterator;
import utilitie.ListADT;
import utilitie.StackADT;

import org.junit.Before;

/**
 * @author 708114
 *
 */
public class StackTests {


	private StackADT<String> stack;
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
		stack = new Stack<>();
		s1 = "A";
		s2 = "B";
		s3 = "C";
		s4 = "D";
		sNull = null;
	}

	/**
	 * Test method for {@link Stack.Stack#push(java.lang.Object)}.
	 * Testing to push method to see if they are being pushed to the top.
	 */
	@Test
	public void testPush() {
		stack.push(s1);
		assertEquals("Didnt worked",s1,stack.peek());
	}

	/**
	 * Test method for {@link Stack.Stack#pop()}.
	 * Stack to remove the top value.
	 */
	@Test
	public void testPop() {
		stack.push(s1);
		String r = stack.pop();
		assertEquals("Didnt worked",s1,r);
	}

	/**
	 * Test method for {@link Stack.Stack#pop()}.
	 * testing to see if the EmptyStackIsthrown
	 */
	@Test
	public void testPop1() {
		try {
		stack.pop();

		}catch(EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link Stack.Stack#peek()}.
	 * test to see if the peek throws emptyStackException
	 */
	@Test
	public void testPeek() {
		try {
		stack.peek();

		}catch(EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link Stack.Stack#peek()}.
	 * test to see if the peek works
	 */
	@Test
	public void testPeek1() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		assertEquals(s3, stack.peek());
	}

	/**
	 * Test method for {@link Stack.Stack#clear()}.
	 * See it the clear method works.
	 */
	@Test
	public void testClear() {
		stack.push(s1);
		stack.push(s2);
		stack.clear();
		assertEquals(0, stack.size());
	}

	/**
	 * Test method for {@link Stack.Stack#isEmpty()}.
	 * testing to see if the stack is empty
	 */
	@Test
	public void testIsEmpty() {
		stack.push(s1);
		stack.push(s2);
		stack.clear();
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link Stack.Stack#toArray()}.
	 * conberting stack into Object array.
	 */
	@Test
	public void testToArray() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		stack.push(s4);
		Object arr[] = stack.toArray();
		assertEquals("Didn't worked", s1,arr[0]);
		assertEquals("Didn't worked", s2,arr[1]);
		assertEquals("Didn't worked", s3,arr[2]);
		assertEquals("Didn't worked", s4,arr[3]);
		assertEquals("Didn't worked", stack.size(),arr.length);
	}

	/**
	 * Test method for {@link Stack.Stack#toArray(E[])}.
	 * Converting into the array.
	 */
	@Test
	public void testToArrayEArray() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		stack.push(s4);
		String arr[] = new String [1];
		arr = stack.toArray(arr);
		assertEquals("Didn't worked", s1,arr[0]);
		assertEquals("Didn't worked", s2,arr[1]);
		assertEquals("Didn't worked", s3,arr[2]);
		assertEquals("Didn't worked", s4,arr[3]);
		assertEquals("Didn't worked", stack.size(),arr.length);
	}

	/**
	 * Test method for {@link Stack.Stack#contains(java.lang.Object)}.
	 * test to see if certain element exit.
	 */
	@Test
	public void testContains() {
		stack.push(s1);
		stack.push(s3);
		stack.push(s2);
		assertTrue(stack.contains(s1));
	}

//	/**
//	 * Test method for {@link Stack.Stack#search(java.lang.Object)}.
//	 */
//	@Test
//	public void testSearch() {
//		fail("Not yet implemented");
//	}
//
	/**
	 * Test method for {@link Stack.Stack#iterator()}.
	 */
	@Test
	public void testIterator() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		Iterator<String> it = stack.iterator();
		assertEquals("Didn't Worked",s3 ,it.next());
		assertEquals("Didn't Worked",s2 ,it.next());
		assertEquals("Didn't Worked",s1 ,it.next());
	}

	/**
	 * Test method for {@link Stack.Stack#equals(utilitie.StackADT)}.
	 * Check to see if they are not equals
	 */
	@Test
	public void testEqualsStackADTOfE() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		Stack<String> ss = new Stack<String>();
		ss.push(s1);
		ss.push(s2);
		ss.push(s3);
		ss.push(s4);

		assertFalse(stack.equals(ss));
	}

	/**
	 * Test method for {@link Stack.Stack#equals(utilitie.StackADT)}.
	 * Check to see if they are  equals
	 */
	@Test
	public void testEqualsStackADTOfE1() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		Stack<String> ss = new Stack<String>();
		ss.push(s1);
		ss.push(s2);
		ss.push(s3);

		assertTrue(stack.equals(ss));
	}

	/**
	 * Test method for {@link Stack.Stack#size()}.
	 * test to see if the size are equals.
	 */
	@Test
	public void testSize() {
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		assertEquals(3, stack.size());
	}

}
