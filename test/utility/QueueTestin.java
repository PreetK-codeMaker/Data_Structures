/**
 *
 */
package utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exceptions.EmptyQueueException;
import QueueDLL.QueDLL;
import utilitie.Iterator;
import utilitie.QueueADT;

/**
 * @author 708114
 *
 */
public class QueueTestin {

	private QueueADT<String> qu;
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
		qu = new QueDLL<>();
		s1 = "A";
		s2 = "B";
		s3 = "C";
		s4 = "D";
		sNull = null;

	}


	/**
	 * Test method for {@link QueueDLL.QueDLL#enqueue(java.lang.Object)}.
	 * testing to add to the of the queue
	 */
	@Test
	public void testEnqueue() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		try {
			assertEquals(s1,qu.peek());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#enqueue(java.lang.Object)}.
	 * testing to add to get empty stack error to be thrpwn.
	 */
	@Test
	public void testEnqueue1() {

		try {
			qu.peek();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}

	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#dequeue()}.
	 * removing element from the
	 */
	@Test
	public void testDequeue() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		qu.enqueue(s3);
		qu.enqueue(s4);

		try {
			String r = qu.dequeue();
			assertEquals(s1, r);
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Test method for {@link QueueDLL.QueDLL#dequeue()}.
	 * Getting the EmotyQueException to be thrown
	 */
	@Test
	public void testDequeue1() {
		try {
			 qu.dequeue();
			fail("Not working at all");
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#peek()}.
	 * Check the element at the very top be removed.
	 */
	@Test
	public void testPeek() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		try {
			assertEquals(s1,qu.peek());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#dequeueAll()}.
	 * Remove everthing in the Que
	 */
	@Test
	public void testDequeueAll() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		qu.dequeueAll();
			assertEquals(0,qu.size());

	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#isEmpty()}.
	 * testing to see if the Que is empty or not.
	 */
	@Test
	public void testIsEmpty() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		assertFalse(qu.isEmpty());

	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#iterator()}.
	 */
	@Test
	public void testIterator() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		qu.enqueue(s3);
		Iterator<String> it = qu.iterator();
		assertEquals("Didn't Worked",s1 ,it.next());
		assertEquals("Didn't Worked",s2 ,it.next());
		assertEquals("Didn't Worked",s3 ,it.next());

	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#equals(utilitie.QueueADT)}.
	 * Checking if they are not equal.
	 */
	@Test
	public void testEqualsQueueADTOfE() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		qu.enqueue(s3);
		QueDLL<String> ss = new QueDLL<String>();
		ss.enqueue(s1);
		ss.enqueue(s2);
		ss.enqueue(s3);
		ss.enqueue(s4);

		assertFalse(qu.equals(ss));
	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#toArray()}.
	 * Converting the que into array
	 */
	@Test
	public void testToArray() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		qu.enqueue(s3);
		qu.enqueue(s4);
		Object arr [] = qu.toArray();
		assertEquals("Didn't worked", s1,arr[0]);
		assertEquals("Didn't worked", s2,arr[1]);
		assertEquals("Didn't worked", s3,arr[2]);
		assertEquals("Didn't worked", s4,arr[3]);
		assertEquals("Didn't worked", qu.size(),arr.length);
	}

	/**
	 * Test method for {@link QueueDLL.QueDLL#toArray(E[])}.
	 * Converting the qu into the array.
	 */
	@Test
	public void testToArrayEArray() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		qu.enqueue(s3);
		qu.enqueue(s4);
		String arr [] = new String[1];
		arr = qu.toArray(arr);
		assertEquals("Didn't worked", s1,arr[0]);
		assertEquals("Didn't worked", s2,arr[1]);
		assertEquals("Didn't worked", s3,arr[2]);
		assertEquals("Didn't worked", s4,arr[3]);
		assertEquals("Didn't worked", qu.size(),arr.length);

	}
//
	/**
	 * Test method for {@link QueueDLL.QueDLL#size()}.
	 * Testing the size
	 */
	@Test
	public void testSize() {
		qu.enqueue(s1);
		qu.enqueue(s2);
		qu.enqueue(s3);

		assertEquals(3, qu.size());
	}

}
