package main.java.com.kangmin.datastructure.trie;

public class Trie {

    private static final short R = 26;

    private static class TrieNode {

        private boolean isEnd;
        private final TrieNode[] links;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode trieNode) {
            links[ch - 'a'] = trieNode;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        final TrieNode node = searchPrefixNode(word);
        if (node == null) {
            return false;
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefixNode(prefix) != null;
    }

    private TrieNode searchPrefixNode(final String word) {
        if (word == null || word.isEmpty()) {
            return null;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
               return null;
            }
            node = node.get(ch);
        }
        return node;
    }
}
