/**
 * 
 */
package com.santhosh.algorithms.test.trie;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.santhosh.algorthms.trie.Trie;

/**
 * @author santhosh
 *
 */
public class TrieTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertAndSearch() {
		Trie trie = new Trie();
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++) {
			trie.insertWord(keys[i]);
		}

		// Search for different keys
		assertTrue(trie.searchWord("the"));
		assertFalse(trie.searchWord("these"));
		assertTrue(trie.searchWord("their"));
		assertFalse(trie.searchWord("thaw"));

	}

	@Test
	public void testInsertSearchinEmptyTree() {
		Trie trie = new Trie();
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = {  };

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			trie.insertWord(keys[i]);

		// Search for different keys
		assertFalse(trie.searchWord("a"));
		assertFalse(trie.searchWord("aa"));
		assertFalse(trie.searchWord("aaaaaaaaaaaa"));
		assertFalse(trie.searchWord("aabaaa"));

	}
	
	@Test
	public void testInsertSearchwithRepetingWords() {
		Trie trie = new Trie();
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "cat","cat","cat" };

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			trie.insertWord(keys[i]);

		// Search for different keys
		assertTrue(trie.searchWord("cat"));
		assertTrue(trie.searchWord("ca"));
		

	}
	
	@Test
	public void testPrefixCount() {
		Trie trie = new Trie();
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "cat","dog","catamaran","catholic","catharsis","caterpillar","cab","cameo" };
		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++) {
			trie.insertWord(keys[i]);
		}
		// Search for different keys
		assertEquals(5,trie.getPrefixCount("cat"));
		assertEquals(0,trie.getPrefixCount("catp"));
		assertEquals(7,trie.getPrefixCount("ca"));
		assertEquals(1,trie.getPrefixCount("cab"));
	}
	
	@Test
	public void testPrefixCountWithRepetingwords() {
		Trie trie = new Trie();
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "cat","cat","cat","cat","bat","xacat","cat","bocat" };
		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++) {
			trie.insertWord(keys[i]);
		}
		// Search for different keys
		assertEquals(5,trie.getPrefixCount("cat"));
		assertEquals(0,trie.getPrefixCount("catp"));
		assertEquals(5,trie.getPrefixCount("ca"));
		assertEquals(0,trie.getPrefixCount("cab"));
	}
	
	@Test
	public void testPrefixCountWithRepetingSameLetter() {
		Trie trie = new Trie();
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "a","aa","aaa","aaaa","aaaaa","aaaaaa" };
		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++) {
			trie.insertWord(keys[i]);
		}
		// Search for different keys
		assertEquals(6,trie.getPrefixCount("a"));
		assertEquals(2,trie.getPrefixCount("aa"));
		assertEquals(3,trie.getPrefixCount("aaa"));
		assertEquals(4,trie.getPrefixCount("aaaa"));
	}

	
}
