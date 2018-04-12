package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie {
    private class TrieNode {
        private Map<Character, TrieNode> m = new HashMap<>();
        private Set<Character> word = new HashSet<>();

        public TrieNode add(Character c, Boolean isWord) {
            TrieNode trieNode = null;
            if (m.containsKey(c)) {
                trieNode = m.get(c);
            } else {
                trieNode = new TrieNode();
                m.put(c, trieNode);
            }
            if (isWord) word.add(c);
            return trieNode;
        }

        public TrieNode search(Character c) {
            if (m.containsKey(c)) {
                return m.get(c);
            }

            return null;
        }

        public Boolean isWord(Character c) {
            return word.contains(c);
        }
    }

    TrieNode root = null;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word != null) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                if (i == chars.length - 1) {
                    node = node.add(chars[i], true);
                } else {
                    node = node.add(chars[i], false);
                }
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word != null) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {

                if (i == chars.length - 1) {
                    if (node.search(chars[i]) != null) {
                        return node.isWord(chars[i]);
                    }
                } else {
                    node = node.search(chars[i]);
                    if (node == null) return false;
                }
            }
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix != null) {
            char[] chars = prefix.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                node = node.search(chars[i]);
                if (node == null) return false;
            }
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("am");
        trie.insert("bad");
        trie.insert("be");
        trie.insert("so");

        System.out.println(trie.startsWith("x"));
    }

}
