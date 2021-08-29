package main.java.com.kangmin.datastructure.trie;

import java.util.LinkedList;
import java.util.Queue;

//  Trie + BFS
public final class LongestWordInDictionary {

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        return trie.findLongestWord();
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    static class Trie {
        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isWord = true;
            node.word = word;
        }

        String findLongestWord() {
            String result = null;
            Queue<TrieNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TrieNode node = queue.poll();
                    for (int j = 25; j >= 0; j--) {
                        assert node != null;
                        if (node.children[j] != null && node.children[j].isWord) {
                            result = node.children[j].word;
                            queue.offer(node.children[j]);
                        }
                    }
                }
            }
            return result;
        }
    }
}

//class Solution {
//    public String longestWord(String[] words) {
//        Arrays.sort(words);
//        Set<String> built = new HashSet<String>();
//        String res = "";
//        for (String w : words) {
//            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
//                res = w.length() > res.length() ? w : res;
//                built.add(w);
//            }
//        }
//        return res;
//    }
//}
