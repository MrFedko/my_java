package redBlackTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedBlackTree {

    private Node root;

    public boolean add(int value){
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node(value);
            root.color = Color.BLACK;
            return true;
        }
    }

    private boolean addNode(Node node, int value){
        if (node.value == value){
            return false;
        } else {
            if (node.value > value) {
                if(node.leftChild != null){
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node(value);
                    return true;
                }
            } else {
                if (node.rightChild != null){
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node(value);
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node){
        Node result = node;
        boolean neadRebalance;
        do {
            neadRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                neadRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                neadRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                neadRebalance = true;
                colorSwap(result);
            }
        } while (neadRebalance);
        return result;
    }

    private Node leftSwap(Node node){
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node rightSwap(Node node){
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private void colorSwap(Node node){
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }


    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        private Color color;

        Node (int num){
            value = num;
            color = Color.RED;
            leftChild = null;
            rightChild = null;
        }

        @Override
        public String toString() {
            return "Node {" +
                    "value = " + value + ", " +
                    "color = " + color +
                    "}";
        }
    }

    private enum Color {
        RED,
        BLACK
    }

    public static void main(String[] args) {
        final RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("add complete");
                } catch (Exception a) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

