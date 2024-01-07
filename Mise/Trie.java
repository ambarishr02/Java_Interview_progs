import java.util.Iterator;
import java.util.LinkedList;

class TrieNode {
	char ch;
	boolean endOfWord;
	LinkedList<TrieNode> childList;
	int count;

	public TrieNode(char ch) {
		this.ch = ch;
		this.childList = new LinkedList<TrieNode>();
		this.endOfWord = false;
		this.count = 0;
	}

	public TrieNode getChildNode(char ch) {
		if (this.childList != null) {
			for (TrieNode node : this.childList) {
				if (node.ch == ch) {
					return node;
				}
			}
		}
		return null;
	}

	public void addChildNode(TrieNode n) {
		this.childList.add(n);
	}

}

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode(' ');
	}

	public void insert(String word) {

		if (search(word))
			return;
		TrieNode current = root;
		for (char ch : word.toCharArray()) {

			if (current.getChildNode(ch) == null) {
				current.addChildNode(new TrieNode(ch));
				current = current.getChildNode(ch);
			} else {
				current = current.getChildNode(ch);
			}
			current.count++;
		}
		current.endOfWord = true;

	}

	public boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (current.getChildNode(ch) == null) {
				return false;

			} else {
				current = current.getChildNode(ch);
			}
			if (current.endOfWord)
				return true;
		}

		return false;
	}

	public void remove(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = current.getChildNode(ch);
			if (child.count == 1)
				current.childList.remove(child);
			else {
				child.count--;
				current = child;
			}
		}
		current.endOfWord = false;
	}

	public static void printAllWordsInTrie(TrieNode root, String s) {
		TrieNode current = root;
		if (root.childList == null || root.childList.size() == 0)
			return;
		Iterator iter = current.childList.iterator();
		while (iter.hasNext()) {
			TrieNode node = (TrieNode) iter.next();
			s += node.ch;
			printAllWordsInTrie(node, s);
			if (node.endOfWord == true) {
				System.out.print(" " + s);
				s = s.substring(0, s.length() - 1);
			} else {
				s = s.substring(0, s.length() - 1);
			}
		}

	}

	// Driver
	public static void main(String args[]) {
//		// Input keys (use only 'a' through 'z' and lower case)
//		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
		Trie t = new Trie();
//		
//		
//		String output[] = { "Not present in trie", "Present in trie" };

		t.insert("ABC");
		t.insert("AC");
//        t.insert("do");
//        t.insert("he");
//        t.insert("hen");
//        t.insert("heat");

		System.out.println("hen present in trie : " + t.search("ABC"));
		System.out.println("hear present in trie : " + t.search("AC"));
		System.out.println("deal present in trie : " + t.search("AD"));
		System.out.println("========================");
		System.out.println("Printing all word present in trie : ");

		printAllWordsInTrie(t.root, "");
		// t.remove("AC");
		// printAllWordsInTrie(t.root,"");

	}

}
