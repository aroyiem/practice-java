package com.practice.collections.dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchWord {

    class BTree {
        char c;
        String word;
        Map<Character, BTree> childs;

        public BTree(char c) {
            this.c = c;
            this.word = null;
            this.childs = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        String[] wordDB = {"food", "book", "full", "fool", "word", "fast"};
        SearchWord searchWord = new SearchWord();
        BTree tree = searchWord.buildTree(wordDB);
        System.out.println(tree);
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("\nSearch");
            String searchedText = in.nextLine();
            searchWord.search(tree, searchedText);
        }
    }

    void search(BTree root, String word) {
        for(int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(!root.childs.containsKey(c)) {
                return;
            }
            root = root.childs.get(c);
        }
        print(root);
    }

    void print(BTree root) {
        if(root.word != null) {
            System.out.println(root.word);
        }
        if(root.childs.isEmpty()) {
            return;
        }
        for(Map.Entry<Character, BTree> entry: root.childs.entrySet()) {
            print(entry.getValue());
        }
    }

    private BTree buildTree(String[] wordDB) {
        BTree root = new BTree(' ');
        // iterate the array
        for(String word: wordDB) {
            BTree current = root;
            // scan each character in the word
            for(int i = 0; i< word.length(); i++) {
                char c = word.charAt(i);
                if(current.childs.keySet().contains(c)) {
                    current = current.childs.get(c);
                } else {
                    BTree node = new BTree(c);
                    current.childs.put(c, node);
                    current = node;
                }
            }
            current.word = word;
        }
        return root;
    }
}
