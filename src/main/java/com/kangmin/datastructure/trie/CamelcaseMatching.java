package main.java.com.kangmin.datastructure.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CamelcaseMatching {

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> results = new ArrayList<>();
        TrieNode root = new TrieNode();
        TrieNode origRoot = root;
        for (int i = 0; i < pattern.length(); i++) {
            TrieNode temp = new TrieNode();
            root.children.put(pattern.charAt(i), temp);
            root = temp;
        }
        root.endOfWord = true;
        for (String query : queries) {
            boolean flag = true;
            TrieNode realRoot = origRoot;
            for (int i = 0; i < query.length(); i++) {
                int charCode = query.charAt(i);
                if (realRoot.children.get(query.charAt(i)) == null && charCode >= 65 && charCode <= 90) {
                    flag = false;
                    break;
                }
                if (realRoot.children.get(query.charAt(i)) != null)
                    realRoot = realRoot.children.get(query.charAt(i));
            }
            if (flag && realRoot.endOfWord) results.add(true);
            else results.add(false);
        }
        return results;
    }
}
