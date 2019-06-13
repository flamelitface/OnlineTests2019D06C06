package com.acquisio.basic.java.question02;

/**
 * QUESTION 2: TreeNode
 * Using the tree structure define at
 * http://en.wikipedia.org/wiki/File:Binary_tree.svg,
 * add the code necessary to optain the following output.
 * ..2
 * ....7
 * ......2
 * ......6
 * ........5
 * ........11
 * ....5
 * ......9
 * ........4
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
public class TreeNavigation {

    private final String depthIndicator = "..";

    public static void main(String[] args) {
        TreeNavigation main = new TreeNavigation();
        main.treeNode();
    }

    private void treeNode() {
        Node n1 = new Node("6", new Node("5"), new Node("11"));
        Node n2 = new Node("7", new Node("2"), n1);
        Node n3 = new Node("9", new Node("4"));
        Node n4 = new Node("5", null, n3);
        Node n = new Node("2", n2, n4);

        System.out.println(printTreeNodes(n));
    }

    public String printTreeNodes(Node node) {
        return printTreeNodes(new StringBuilder(), 1, node);
    }

    private String printTreeNodes(StringBuilder sb, int depth, Node node) {

        for (int i = 0; i < depth; i++) {
            sb.append(depthIndicator);
        }
        sb.append(node.name);
        sb.append(System.lineSeparator());

        if(node.children != null && node.children.length > 0) {
            for (Node child : node.children) {
                if(child != null) {
                    printTreeNodes(sb, depth + 1, child);
                }
            }
        }
        return sb.toString();
    }
}
