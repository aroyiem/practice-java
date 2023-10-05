package com.practice.collections.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void add(TreeNode start, TreeNode newNode) {
        if(root == null) {
            root = newNode;
            return;
        }
        // check for value
        if(newNode.getValue() > start.getValue()) {
            // move to the right
            if(start.getRight() == null) {
                start.setRight(newNode);
                return;
            }
            add(start.getRight(), newNode);
        } else if (newNode.getValue() < start.getValue()) {
            // move to the left
            if(start.getLeft() == null) {
                start.setLeft(newNode);
                return;
            }
            add(start.getLeft(), newNode);
        }
    }

    public int getDepth() {
        if(root == null) {
            return 0;
        }
        int depth = 0;

        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(root, 0));

        while (!queue.isEmpty()) {
            NodeLevel nodeDetails = queue.poll();
            depth = Math.max(depth, nodeDetails.level);
            if(nodeDetails.node.getLeft() != null) {
                queue.add(new NodeLevel(nodeDetails.node.getLeft(), nodeDetails.level + 1));
            }
            if(nodeDetails.node.getRight() != null) {
                queue.add(new NodeLevel(nodeDetails.node.getRight(), nodeDetails.level + 1));
            }
        }
        return depth + 1;
    }

    class NodeLevel {
        TreeNode node;
        int level;

        public NodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
